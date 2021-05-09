package xiaojian.sync;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author 小贱
 * @create 2021-04-06 20:03
 */
public class SynchronizedTest {
    public static void main(String[] args) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Object lock = new Object();

        System.out.println(ClassLayout.parseInstance(lock).toPrintable());

//        lock.hashCode();
//        System.out.println(ClassLayout.parseInstance(lock).toPrintable());

        new Thread(() -> {
            synchronized (lock) {
                System.out.println(ClassLayout.parseInstance(lock).toPrintable());
            }
            // 再次进入同步快，lock锁还是偏向当前线程
            synchronized (lock) {
                System.out.println(ClassLayout.parseInstance(lock).toPrintable());
            }
        }).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
