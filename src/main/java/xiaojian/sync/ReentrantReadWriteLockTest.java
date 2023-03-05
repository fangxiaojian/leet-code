package xiaojian.sync;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author: fanghanj
 * @email: fanghanj@minstone.com.cn
 * @date 2023年01月23日 16:33
 **/
public class ReentrantReadWriteLockTest {

    public static void main(String[] args) {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        new Thread(() -> {
            lock.writeLock().lock();
            System.out.println(Thread.currentThread().getName() + "获取写锁！");
            lock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + "获取读锁！");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + "释放写锁！");
            lock.writeLock().unlock();
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + "释放读锁！");
            lock.readLock().unlock();
        }, "t1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        new Thread(() -> {
            lock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + "获取读锁！");
            System.out.println(Thread.currentThread().getName() + "释放读锁！");
            lock.readLock().unlock();
        }, "t2").start();
    }
}
