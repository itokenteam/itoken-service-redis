package com.zhu.itoken.service.redis.controller;

import com.zhu.itoken.service.redis.service.RedisService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.StringUtils;

@RestController
public class RedisController {

    @Autowired
    private RedisService redisService;

    @Autowired
    StringRedisTemplate springRedisTemplate;

    @RequestMapping(value = "/put",method = RequestMethod.POST)
    public String put( String key, String value, long seconds){
        //redisService.put(key, value, seconds);
        springRedisTemplate.opsForValue().append(key,value);
        return "ok";
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String get(String key){
//        Object o = redisService.get(key);
        Object o = springRedisTemplate.opsForValue().get(key);
        if (o != null) {
            String json = String.valueOf(o);
            return json;
        }else {
            return null;
        }
    }
}
