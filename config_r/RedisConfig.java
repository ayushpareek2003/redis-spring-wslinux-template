package com. "add you package path " .config_r; // change this according to you 



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

        
        @Bean
        public RedisTemplate redisTemplate(RedisConnectionFactory connectionFactory) {
            RedisTemplate redisTemplate = new RedisTemplate();
            redisTemplate.setConnectionFactory(connectionFactory);

            redisTemplate.setKeySerializer(new StringRedisSerializer());

            redisTemplate.setValueSerializer(new StringRedisSerializer());

            return redisTemplate;

        }
}
