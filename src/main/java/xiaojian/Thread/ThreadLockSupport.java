package xiaojian.Thread;

import java.util.concurrent.locks.LockSupport;

/**
 * @author: fanghanj
 * @email: fanghanj@minstone.com.cn
 * @date 2023年01月15日 17:59
 **/
public class ThreadLockSupport {
    public static void main(String[] args) {
        Thread a = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            LockSupport.park();
            System.out.println("a1");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            LockSupport.park();
            System.out.println("a2");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            LockSupport.park();
            System.out.println("a3");
        }, "a");
        a.start();

        new Thread(() -> {
            LockSupport.unpark(a);
            System.out.println("b1");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            LockSupport.unpark(a);
            System.out.println("b2");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            LockSupport.unpark(a);
            System.out.println("b3");
        }, "b").start();


    }
}
