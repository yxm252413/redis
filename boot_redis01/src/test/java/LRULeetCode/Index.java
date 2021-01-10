package LRULeetCode;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Index {
    //漏桶：水滴的漏出速率是每秒 1 滴
    private LeakyBucket leakyBucket = new LeakyBucket(1);

    //漏桶限流
    @RequestMapping("/searchCustomerInfoByLeakyBucket")
    public Object searchCustomerInfoByLeakyBucket() {
        // 1.限流判断
        boolean acquire = leakyBucket.acquire();
        if (!acquire) {
            System.out.println("稍后再试！");
            return "稍后再试！";
        }
        // 2.如果没有达到限流的要求,直接调用接口查询
        System.out.println("漏桶算法");
        return "漏桶算法";
    }


}