package xiaojian.ThreadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author 小贱
 * @create 2021-04-29 下午3:24
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(1);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 3, 100, TimeUnit.SECONDS, queue);

        executor.execute(()->{
            while (true) {
                int i =1;
            }
        });
        executor.execute(()->{
            while (true) {
                int i =1;
            }
        });
        executor.execute(()->{
            while (true) {
                int i =1;
            }
        });
    }
}
