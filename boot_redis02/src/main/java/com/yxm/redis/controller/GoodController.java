package com.yxm.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
            //加锁
            boolean flag = stringRedisTemplate.opsForValue().setIfAbsent(REDIS_LOCK, value).booleanValue();//相当于redis的setNX
            //加过期时间，10秒后会被删除，避免服务宕机，redis无法释放锁的问题
            stringRedisTemplate.expire(REDIS_LOCK, 10L, TimeUnit.SECONDS);
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
            //程序执行完毕，删除redis锁
            stringRedisTemplate.delete(REDIS_LOCK);
        }
    }
}
