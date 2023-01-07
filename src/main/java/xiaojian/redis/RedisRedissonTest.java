package xiaojian.redis;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RReadWriteLock;
import org.redisson.config.Config;

/**
 * @author 小贱
 * @create 2021-04-19 16:58
 */
public class RedisRedissonTest {

    private static Redisson getRedisson(){
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379").setDatabase(0);
        return (Redisson) Redisson.create(config);
    }

    public static void main(String[] args) {
        String lock = "testRedisRedisson";
        Redisson redisson = RedisRedissonTest.getRedisson();
        RLock redissonLock = redisson.getLock(lock);
        redissonLock.lock();
        RReadWriteLock readWriteLock = redisson.getReadWriteLock("read");
        RLock rLock = readWriteLock.readLock();
        RLock wLock = readWriteLock.writeLock();
        rLock.lock();
        rLock.unlock();
        wLock.lock();
        wLock.unlock();
        redissonLock.unlock();
    }
}
