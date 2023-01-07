package xiaojian.sync;

/**
 * @author 小贱
 * @create 2021-04-11 00:48
 */
public class SynchronizedShowByteCode {
    public static void main(String[] args) {
        SynchronizedShowByteCode s = new SynchronizedShowByteCode();
        new Thread(()->{
            System.out.println("获取对象锁资源");
            System.out.println(s.add(1, 2));
            System.out.println("释放对象锁资源");
        }).start();
        new Thread(()->{
            s.n();
        }).start();
        new Thread(()->{
            System.out.println("获取类锁资源");
            System.out.println(del(2,1));
            System.out.println("释放类锁资源");
        }).start();
        new Thread(()->{
            s.m();
        }).start();
    }

    public synchronized int add(int a, int b) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return a+b;
    }

    public static synchronized int del(int a, int b) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return a-b;
    }

    public void m() {
        synchronized (SynchronizedShowByteCode.class) {
            System.out.println("类锁");
        }
    }

    public void n() {
        synchronized (this) {
            System.out.println("对象锁");
        }
    }
}
