package xiaojian.Thread;

/**
 * @author 小贱
 * @create 2021-04-26 14:35
 */
public class ThreadTest extends Thread {
    public static void main(String[] args) {
        Thread t1 = new ThreadTest();
        Thread t2 = new ThreadTest();
        Thread t3 = new ThreadTest();
        Thread t4 = new ThreadTest();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        System.out.println("等待thread 线程执行完 " + t1.getName());
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread 线程执行完毕");
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                if (Thread.currentThread().getName().equals("Thread-0")) {
                    Thread.yield();
                }else {
                    System.out.println(i + "---" + Thread.currentThread().getName());
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


