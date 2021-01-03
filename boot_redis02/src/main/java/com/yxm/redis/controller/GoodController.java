package com.yxm.redis.controller;

import com.yxm.redis.config.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Classname GoodController
 * @Description TODO
 * @Date 2021/1/1
 * @Created by yxm
 */
@RestController
public class GoodController {

    //redis锁的key
    public static final String REDIS_LOCK = "yxm";
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Value("${server.port}")
    private String serverPort;

    private Lock lock = new ReentrantLock();

    @GetMapping("/buy_goods")
    public String buy_Goods() {
        //redis锁的value
        String value = UUID.randomUUID().toString() + Thread.currentThread().getName();
        try {
//            设置key+过期时间分开了，必须要合并成一行具备原子性
            boolean flag = stringRedisTemplate.opsForValue().setIfAbsent(REDIS_LOCK, value, 10L, TimeUnit.SECONDS).booleanValue();//相当于redis的setNX
            String result = stringRedisTemplate.opsForValue().get("goods:001");
            int goodsNumber = result == null ? 0 : Integer.parseInt(result);

            if (!flag) {
                return "抢锁失败！！！";
            }
            if (goodsNumber > 0) {
                int realNumber = goodsNumber - 1;
                stringRedisTemplate.opsForValue().set("goods:001", realNumber + "");
                System.out.println("你已经成功秒杀商品，此时还剩余：" + realNumber + "件" + "\t 服务器端口: " + serverPort);
                return "你已经成功秒杀商品，此时还剩余：" + realNumber + "件" + "\t 服务器端口: " + serverPort;
            } else {
                System.out.println("商品已经售罄/活动结束/调用超时，欢迎下次光临" + "\t 服务器端口: " + serverPort);
            }
            return "商品已经售罄/活动结束/调用超时，欢迎下次光临" + "\t 服务器端口: " + serverPort;
        } finally {//无论如何都会执行的代码块，如果上面的代码出现异常，redis锁也可以正常释放
            Jedis jedis = null;
            //lur脚本
            String script = "if redis.call('get',KEYS[1]) == ARGV[1]" +
                    "then" +
                    "return redis.call('del',KEYS[1])" +
                    "else" +
                    "return 0" +
                    "end";
            try {
                jedis = RedisUtils.getJedis();
                //Collections.singletonList(REDIS_LOCK)把字符串转为集合
                Object o = jedis.eval(script, Collections.singletonList(REDIS_LOCK), Collections.singletonList(value));//执行脚本
                if ("1".equals(o.toString())) {
                    System.out.println("----------del redis lock ok");
                } else {
                    System.out.println("----------del redis lock error");
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (null != jedis) {//释放资源
                    jedis.close();
                }
            }
        }
    }
}
