package xiaojian.sync;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;
import sun.misc.Unsafe;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;

public class SynchronizedExistenceCertification {

    private static long lastAddr;

    public static void main(String[] args) throws Exception {
        // 直接休眠5秒，或者用-XX:BiasedLockingStartupDelay=0关闭偏向锁延迟
        Thread.sleep(5000);

        // 反射获取sun.misc的Unsafe对象，用来查看锁的对象头的信息
        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        final Unsafe unsafe = (Unsafe) theUnsafe.get(null);

        // 锁对象
        TestObject lock = new TestObject();
        System.out.println("创建对象");
        lastAddr = VM.current().addressOf(lock);
        // TODO 64位JDK对象头为 64bit = 8Byte，如果是32位JDK则需要换成unsafe.getInt
//        printf("1_无锁状态：" + getLongBinaryString(unsafe.getLong(lock, 0L)));
        printf("1_无锁状态：" , ClassLayout.parseInstance(lock).toPrintable());

        // 如果不执行hashCode方法，则对象头的中的hashCode为0，
        // 但是如果执行了hashCode（identity hashcode，重载过的hashCode方法则不受影响），会导致偏向锁的标识位变为0（不可偏向状态），
        // 且后续的加锁不会走偏向锁而是直接到轻量级锁（被hash的对象不可被用作偏向锁）
        // lock.hashCode();
        //printf("锁对象hash：" + getLongBinaryString(lock.hashCode()));

        printf("2_无锁状态：" , ClassLayout.parseInstance(lock).toPrintable());

        //printf("主线程hash：" +getLongBinaryString(Thread.currentThread().hashCode()));
        //printf("主线程ID：" +getLongBinaryString(Thread.currentThread().getId()) + "\n");
        // 无锁 --> 偏向锁
        new Thread(() -> {
            synchronized (lock) {
                printf("3_偏向锁：" ,ClassLayout.parseInstance(lock).toPrintable());
                //printf("偏向线程hash：" +getLongBinaryString(Thread.currentThread().hashCode()));
                //printf("偏向线程ID：" +getLongBinaryString(Thread.currentThread().getId()) + "\n");
                // 如果锁对象已经进入了偏向状态，再调用hashCode()，会导致锁直接膨胀为重量级锁
//                lock.hashCode();
            }
            // 再次进入同步快，lock锁还是偏向当前线程
            synchronized (lock) {
                printf("4_偏向锁：" ,ClassLayout.parseInstance(lock).toPrintable());
                //printf("偏向线程hash：" +getLongBinaryString(Thread.currentThread().hashCode()));
                //printf("偏向线程ID：" +getLongBinaryString(Thread.currentThread().getId()) + "\n");
            }
        }).start();
        Thread.sleep(1000);

        // 可以看到就算偏向的线程结束，锁对象的偏向锁也不会自动撤销
        printf("5_偏向线程结束：" ,ClassLayout.parseInstance(lock).toPrintable());

        // 偏向锁 --> 轻量级锁
        synchronized (lock) {

            // 对象头为：指向线程栈中的锁记录指针
            System.out.println("轻量级锁中。。。。");
            printf("6_轻量级锁：" , ClassLayout.parseInstance(lock).toPrintable());
            // 这里获得轻量级锁的线程是主线程
            printf("轻量级线程hash：" ,getLongBinaryString(Thread.currentThread().hashCode()));
            printf("轻量级线程ID：" ,getLongBinaryString(Thread.currentThread().getId()) + "\n");
        }
        new Thread(() -> {
            synchronized (lock) {
                printf("7_轻量级锁：" ,ClassLayout.parseInstance(lock).toPrintable());
                printf("轻量级线程hash：" ,getLongBinaryString(Thread.currentThread().hashCode()));
                printf("轻量级线程ID：" ,getLongBinaryString(Thread.currentThread().getId()) + "\n");
            }
        }).start();
        Thread.sleep(1000);

        // 轻量级锁 --> 重量级锁
        synchronized (lock) {
            int i = 123;
            // 注意：6_轻量级锁 和 8_轻量级锁 的对象头是一样的，证明线程释放锁后，栈帧中的锁记录并未清除，如果方法返回，锁记录是否保留还是清除？
            printf("8_轻量级锁：" , ClassLayout.parseInstance(lock).toPrintable());
            // 在锁已经获取了lock的轻量级锁的情况下，子线程来获取锁，则锁会膨胀为重量级锁
            new Thread(() -> {
                synchronized (lock) {
                    printf("9_重量级锁：" ,ClassLayout.parseInstance(lock).toPrintable());
                    gc(lock);
                    printf("GC9_重量级锁：" ,ClassLayout.parseInstance(lock).toPrintable());
                    //printf("重量级线程hash：" +getLongBinaryString(Thread.currentThread().hashCode()));
                    //printf("重量级线程ID：" +getLongBinaryString(Thread.currentThread().getId()) + "\n");
                }
            }).start();
            // 同步块中睡眠1秒，不会释放锁，等待子线程请求锁失败导致锁膨胀（见轻量级加锁过程）
            Thread.sleep(1000);
        }
        Thread.sleep(500);
        gc(lock);

        printf("9_重量级锁结束：" ,ClassLayout.parseInstance(lock).toPrintable());

        gc(lock);
        synchronized (lock) {
            // 对象头为：指向线程栈中的锁记录指针
            printf("10_轻量级锁：" , ClassLayout.parseInstance(lock).toPrintable());
            gc(lock);
        }
        new Thread(() -> {
            synchronized (lock) {
                printf("11_轻量级锁：" ,ClassLayout.parseInstance(lock).toPrintable());
                gc(lock);
            }
        }).start();
        gc(lock);
        Thread.sleep(1000);
        printf("最后：" ,ClassLayout.parseInstance(lock).toPrintable());
        System.gc();
    }

    private static String getLongBinaryString(long num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 64; i++) {
            if ((num & 1) == 1) {
                sb.append(1);
            } else {
                sb.append(0);
            }
            num = num >> 1;
        }
        return sb.reverse().toString();
    }



    private static void printf(String name, String str) {
        System.out.println(name + str);
//        // 在文件夹目录下新建文件
//        File file = new File("log.txt");
//
//        FileOutputStream fos = null;
//        OutputStreamWriter osw = null;
//
//        try {
//            if (!file.exists()) {
//                boolean hasFile = file.createNewFile();
//
//                fos = new FileOutputStream(file);
//            } else {
//                fos = new FileOutputStream(file, true);
//            }
//
//            osw = new OutputStreamWriter(fos, "utf-8");
//            // 写入内容
//            osw.write(name + str);
//            // 换行
//            osw.write("\r\n");
//
//        } catch (Exception e) {
//
//        } finally {
//            // 关闭流
//            try {
//                if (osw != null) {
//                    osw.close();
//                }
//                if (fos != null) {
//                    fos.close();
//                }
//            } catch (IOException e) {
//
//            }
//        }
    }

    private static void gc(Object lock) {
        System.out.println("GC=============================>+Object");
        for (int i = 0; i < 5; i++) {
            byte[] bit = new byte[1024 * 1024];
            long currentAddr = VM.current().addressOf(lock);
            if (currentAddr != lastAddr) {
                //地址发生变化的时候，打印对象结构
                ClassLayout layout = ClassLayout.parseInstance(lock);
                System.out.println(layout.toPrintable());
                lastAddr = currentAddr;
            }
        }
    }

    private static void gc() {
        System.out.println("GC=============================>");
        for (int i = 0; i < 5; i++) {
            byte[] bit = new byte[1024 * 1024];
        }
    }
}

class TestObject {
}