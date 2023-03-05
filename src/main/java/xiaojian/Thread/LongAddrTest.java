package xiaojian.Thread;

import java.util.concurrent.atomic.LongAdder;

/**
 * @author: fanghanj
 * @email: fanghanj@minstone.com.cn
 * @date 2023年01月20日 11:31
 **/
public class LongAddrTest {

    public static void main(String[] args) {
        LongAdder longAdder = new LongAdder();
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                while (true) {
                    longAdder.increment();
                    System.out.println(longAdder.sum());
                }
            }, "t" + i).start();
        }
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                while (true) {
                    longAdder.decrement();
                    System.out.println(longAdder.sum());
                }
            }, "p" + i).start();
        }
    }
}
