package xiaojian.redis;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Pipeline;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 小贱
 * @create 2021-04-18 21:31
 */
public class JedisClusterTest {
    public static void main(String[] args) throws IOException {

        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(20);
        config.setMaxIdle(10);
        config.setMinIdle(5);

        JedisPool jedisPool = new JedisPool(config, "127.0.0.1", 6379, 3000, null);
        Jedis jedis = null;
        try {
            //从redis连接池里拿出一个连接执行命令
            jedis = jedisPool.getResource();
//            System.out.println(jedis.set("single", "xiaojian"));
//            System.out.println(jedis.get("single"));

            //管道示例
            //管道的命令执行方式:cat redis.txt | redis‐cli ‐h 127.0.0.1 ‐a password ‐ p 6379 ‐‐pi pe
//            Pipeline pl = jedis.pipelined();
//            for (int i = 0; i < 10; i++) {
//                pl.incr("pipelineKey");
//                pl.set("zhuge" + i, "zhuge");
//            }
//            List<Object> results = pl.syncAndReturnAll();
//            System.out.println(results);
            //lua脚本模拟一个商品减库存的原子操作
            //lua脚本命令执行方式:redis‐cli ‐‐eval /tmp/test.lua , 10
            //初始化商品10016的库存
            jedis.set("product_count_10016", "15");
            String script = " local count = redis.call('get', KEYS[1]) " +
                    " local a = tonumber(count) " +
                    " local b = tonumber(ARGV[1]) " +
                    " if a >= b then " +
                    "     redis.call('set', KEYS[1], (a‐b)) " +
                    "     return 1 " +
                    " end " +
                    "     return 0 ";
            Object obj = jedis.eval(script, Arrays.asList("product_count_10016"), Arrays.asList("10"));
            System.out.println(obj);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //注意这里不是关闭连接，在JedisPool模式下，Jedis会被归还给资源池。
            if (jedis != null) {
                jedis.close();
            }
        }
    }
}
