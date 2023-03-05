package xiaojian.sync;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

/**
 * @author 小贱
 * @create 2021-04-18 16:54
 */
public class Test1 {
    static volatile Object consumer;
    public static void main(String[] args) {
        //这是我们要观察的对象
        Object instance = new Object();
        long lastAddr = VM.current().addressOf(instance);
        for (int i = 0; i < 10000; i++) {
            //查看地址是否发生了变化，代表是否发生了 Survivor 复制，或者是移动到老年代
            long currentAddr = VM.current().addressOf(instance);
            if (currentAddr != lastAddr) {
                //地址发生变化的时候，打印对象结构
                ClassLayout layout = ClassLayout.parseInstance(instance);
                System.out.println(layout.toPrintable());
                lastAddr = currentAddr;
            }
            for (int j = 0; j < 10000; j++) {
                //一直创建新对象
                //因为是volatile的属性更新，不会被编译器优化
                consumer = new Object();
            }
        }
    }
}
