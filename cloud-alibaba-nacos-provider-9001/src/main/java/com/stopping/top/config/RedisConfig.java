package com.stopping.top.config;

import org.redisson.Redisson;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description RedisConfig
 * @Author stopping
 * @date: 2021/4/25 14:22
 */
@Configuration
public class RedisConfig {
    @Bean
    RedisTemplate<String, Serializable> redisTemplate(LettuceConnectionFactory connectionFactory){
        RedisTemplate<String,Serializable> redisTemplate = new RedisTemplate<>();
        //设置连接
        redisTemplate.setConnectionFactory(connectionFactory);
        //处理序列化问题
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //fastjson有漏洞
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        return redisTemplate;
    }
    @Bean
    public Redisson redisson(){
        Config config = new Config();
        config.useSentinelServers().addSentinelAddress("redis://139.224.113.113:26379",
                "redis://139.224.113.113:26380","redis://139.224.113.113:26381").setDatabase(0)
        .setMasterName("redis-master")
        .setConnectTimeout(10000)
        .setTimeout(30000)
        .setRetryInterval(15000)
        .setRetryAttempts(30)
        .setMasterConnectionPoolSize(64)
        .setMasterConnectionMinimumIdleSize(64)
        .setSlaveConnectionMinimumIdleSize(64)
        .setSlaveConnectionPoolSize(64)
        .setCheckSentinelsList(false);
        return (Redisson) Redisson.create(config);
    }
}
