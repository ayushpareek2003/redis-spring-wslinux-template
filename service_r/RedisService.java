package com. "add you package path " .service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;



@Service
@Slf4j
public class RedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    // customized entity so that our values get mapped in that format
    public <T>  T get(String key,Class<T> Entity){
        try {
            Object responseTemp = redisTemplate.opsForValue().get(key);
            ObjectMapper mapper = new ObjectMapper();

            return mapper.readValue(responseTemp.toString(), Entity);
        }
        catch (Exception e) {
            log.error("Exception");

        }

        return null;
    }

    public void set(String key, Object value, Long expire){
        try{
            ObjectMapper mapper = new ObjectMapper();

            String jsonValue=mapper.writeValueAsString(value);  //as we set our setKeySerializer and setValueSerializer as String

            redisTemplate.opsForValue().set(key,jsonValue, expire,TimeUnit.SECONDS);  //here expire is the duration for which it 
                                                                                     // hold that data before making a fresh call to 
                                                                                    // database
        }
        catch (Exception e) {

            log.error("Exception");

        }
    }
}
