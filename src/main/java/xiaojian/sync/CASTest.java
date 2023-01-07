package xiaojian.sync;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 小贱
 * @create 2021-04-06 18:14
 */
public class CASTest {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        int i = atomicInteger.incrementAndGet();
        System.out.println(i);
    }
}
