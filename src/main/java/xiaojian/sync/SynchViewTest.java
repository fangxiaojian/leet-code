package xiaojian.sync;

import xiaojian.Thread.ThreadTest;

/**
 * @author 小贱
 * @create 2021-04-26 17:05
 */
public class SynchViewTest extends Thread {

    private static int count = 0;

    public static void main(String[] args) {
        Thread t1 = new SynchViewTest();
        t1.start();
        for (int i = 0; i < 1000; i++) {
            count++;
            System.out.println("main" + count);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            try {
                synchronized (SynchViewTest.class) {
                    count++;
                    System.out.println("synchronized++" + count);
                    Thread.sleep(1000);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}