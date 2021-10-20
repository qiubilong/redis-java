package com.study.redis.redis.h;

import lombok.Data;

import static com.study.redis.redis.Redis.LRU_CLOCK;
import static com.study.redis.redis.h.REDIS_ENCODING.REDIS_ENCODING_RAW;

/**
 * @author chenxuegui
 * @since 2021.10.20
 * Redis 对象
 */
@Data
public class RedisObject<T> {

    /** 数据类型 */
    public int type;

    /** 数据编码 */
    public int encoding;

    /** 数据编码 */
    public long lru;

    /** 引用计数 */
    public int refcount;

    /** 实际值 */
    public T ptr;


    public static <T> RedisObject<T>  createObject(RedisObjectType type, T ptr){

        RedisObject<T> o = new RedisObject();
        o.type = type.id;
        o.encoding = REDIS_ENCODING_RAW.id;
        o.ptr = ptr;
        o.refcount = 1;
        o.lru = LRU_CLOCK();

        return o;
    }



}
