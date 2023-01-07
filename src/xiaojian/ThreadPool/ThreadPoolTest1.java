package xiaojian.ThreadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author 小贱
 * @create 2021-04-29 下午3:24
 */
public class ThreadPoolTest1 {
    public static void main(String[] args) {
        ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(3);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 3, 10, TimeUnit.SECONDS, queue);

        executor.execute(()->{
            System.out.println(Thread.currentThread().getName() + " start1");
            try {
                Thread.sleep(100000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " sleep 1s, stop");
        });
        executor.execute(()->{
            System.out.println(Thread.currentThread().getName() + " start2");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " sleep 1s, stop");
        });
        executor.execute(()->{
            System.out.println(Thread.currentThread().getName() + " start3");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " sleep 5s, stop");
        });
        executor.execute(()->{
            System.out.println(Thread.currentThread().getName() + " start4");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " sleep 5s, stop");
        });
        executor.execute(()->{
            System.out.println(Thread.currentThread().getName() + " start5");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " sleep 13s, stop");
        });
    }
}
