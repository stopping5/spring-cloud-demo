package com.stopping.top.controller;

import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description PaymentController
 * @Author stopping
 * @date: 2021/4/22 12:29
 */

@RestController
@Slf4j
public class PaymentController
{
    @Value("${server.port}")
    private String serverPort;

    ReentrantLock lock = new ReentrantLock();

    private static final String STOCKLOCK = "LOCK";

    @Resource
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    private Redisson redisson;

    @GetMapping(value = "/payment/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id)
    {
        return "nacos registry, serverPort: "+ serverPort+"\t id"+id;
    }
    @GetMapping(value = "/payment/sell")
    public String sell() throws InterruptedException {

        //redssion
        RLock redissonLock = redisson.getLock(STOCKLOCK);
        redissonLock.lock(10,TimeUnit.SECONDS);
        try {
            String result = stringRedisTemplate.opsForValue().get("goods:001");
            int num = result == null ? 0 : Integer.parseInt(result);
            if (num >0){
                int realNum = num-1;
                stringRedisTemplate.opsForValue().set("goods:001",String.valueOf(realNum));
                log.info("扣减现有库存{},现有库存{}",num,realNum);
                return "成功购买商品，库存剩余"+realNum+",服务端口:"+serverPort;
            }else {
                log.info("库存不足");
            }
        }finally{
            redissonLock.unlock();
        }
        return "获取库存失败";
    }
    //单线程锁在分布式中不起作用
    public String singleThreadLockSell() throws InterruptedException {
        if (lock.tryLock(2, TimeUnit.SECONDS)){
            lock.lock();
            try {
                String result = stringRedisTemplate.opsForValue().get("goods:001");
                int num = result == null ? 0 : Integer.parseInt(result);
                if (num >0){
                    int realNum = num-1;
                    stringRedisTemplate.opsForValue().set("goods:001",String.valueOf(realNum));
                    log.info("扣减现有库存{},现有库存{}",num,realNum);
                    return "成功购买商品，库存剩余"+realNum+",服务端口:"+serverPort;
                }else {
                    log.info("库存不足");
                }
            }finally{
                lock.unlock();
            }
        }else{
            log.info("抢占锁失败");
        }
        return "抢购失败";
    }

    //redis分布式锁
    public String redisLockSell(){
        String lockValue = UUID.randomUUID()+Thread.currentThread().getName();
        boolean flag = stringRedisTemplate.opsForValue().setIfAbsent(STOCKLOCK,lockValue,10L,TimeUnit.SECONDS);

        if (!flag){
            //log.info("抢占分布式锁失败");
            return "抢占锁失败";
        }
        try{
            String result = stringRedisTemplate.opsForValue().get("goods:001");
            int num = result == null ? 0 : Integer.parseInt(result);
            if (num >0){
                int realNum = num-1;
                stringRedisTemplate.opsForValue().set("goods:001",String.valueOf(realNum));
                log.info("扣减现有库存{},现有库存{}",num,realNum);
                return "成功购买商品，库存剩余"+realNum+",服务端口:"+serverPort;
            }else {
                log.info("库存不足");
            }
        }finally {
            if (stringRedisTemplate.opsForValue().get(STOCKLOCK).equalsIgnoreCase(lockValue)){
                stringRedisTemplate.delete(STOCKLOCK);
            }
        }
        return "抢购失败";
    }
}
