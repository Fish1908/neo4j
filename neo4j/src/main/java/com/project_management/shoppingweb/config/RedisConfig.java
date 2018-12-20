package com.project_management.shoppingweb.config;

import com.project_management.shoppingweb.dao.pojo.nodeEntity.Person;
import java.time.Duration;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

/**
 * @ClassName RedisAutoConfig
 * @Description TODO
 * @Author xiaojian
 * @Date 2018/12/17 23:15
 * @Version 1.0
 */
@Configuration
public class RedisConfig extends CachingConfigurerSupport {

  @Bean
  public StringRedisTemplate RedisTemplate(RedisConnectionFactory redisConnectionFactory) {
    StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
    stringRedisTemplate.setConnectionFactory(redisConnectionFactory);

    return stringRedisTemplate;
  }
  @Bean
  public RedisCacheManager userRedisCacheManager(StringRedisTemplate RedisTemplate){
    RedisCacheManager cacheManager =new RedisCacheManager(RedisTemplate);
//    cacheManager.setUsePrefix(true);
    cacheManager.setDefaultExpiration(60L);
    return cacheManager;
  }


}
