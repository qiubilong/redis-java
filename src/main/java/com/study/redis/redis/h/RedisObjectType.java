package com.study.redis.redis.h;

/**
 * @author chenxuegui
 * @since 2021.10.20
 * 对象类型
 */
public enum RedisObjectType {
    REDIS_STRING(0),
    REDIS_LIST(1),
    REDIS_SET(2),
    REDIS_ZSET(3),
    REDIS_HASH(4),

    ;
    public int id;

    RedisObjectType(int id) {
        this.id = id;
    }
}
