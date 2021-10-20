package com.study.redis;

import com.study.redis.redis.Redis;

/**
 * @author chenxuegui
 * @since 2021.10.15
 */
public class RedisAppMain {

    public static void main(String[] args) {

        Redis redis = new Redis();
        redis.main(args);
    }
}
