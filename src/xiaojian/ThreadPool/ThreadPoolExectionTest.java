package xiaojian.ThreadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author 小贱
 * @create 2021-04-29 下午3:24
 */
public class ThreadPoolExectionTest {
    public static void main(String[] args) {
        ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(3);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 3, 10, TimeUnit.SECONDS, queue);

        executor.execute(()->sayHi("1"));
        executor.execute(()->sayHi("2"));
        executor.execute(()->sayHi("3"));
        executor.execute(()->sayHi("4"));
        executor.execute(()->sayHi("5"));

    }
    private static void sayHi(String name) {
        String printStr = "【thread-name:" + Thread.currentThread().getName() + "start ,执行方式:" + name+"】";
        System.out.println(printStr);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("【thread-name:" + Thread.currentThread().getName() + "stop ,执行方式:" + name+"】");
        throw new RuntimeException(printStr + ",我异常啦!哈哈哈!");
    }
}
