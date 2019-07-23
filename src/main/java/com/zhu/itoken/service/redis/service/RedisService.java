package com.zhu.itoken.service.redis.service;

public interface RedisService {

    void put(String key, Object value, long seconds);
    Object get(String key);
}
