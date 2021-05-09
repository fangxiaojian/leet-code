package xiaojian.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 小贱
 * @create 2021-04-25 17:13
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(()->{

        });
    }
}
