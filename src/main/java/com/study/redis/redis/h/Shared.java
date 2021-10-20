package com.study.redis.redis.h;

import static com.study.redis.redis.h.ServerConf.REDIS_SHARED_INTEGERS;

/**
 * @author chenxuegui
 * @since 2021.10.20
 * 共享对象，
 */
public class Shared {

    public static RedisObject crlf;
    public static RedisObject ok;
    public static RedisObject err;
    public static RedisObject emptybulk;
    public static RedisObject czero;
    public static RedisObject cone;
    public static RedisObject cnegone;
    public static RedisObject pong;
    public static RedisObject space;
    public static RedisObject colon;
    public static RedisObject nullbulk;
    public static RedisObject nullmultibulk;
    public static RedisObject queued;
    public static RedisObject emptymultibulk;
    public static RedisObject wrongtypeerr;
    public static RedisObject nokeyerr;
    public static RedisObject syntaxerr;
    public static RedisObject sameobjecterr;
    public static RedisObject outofrangeerr;
    public static RedisObject noscripterr;
    public static RedisObject loadingerr;
    public static RedisObject slowscripterr;
    public static RedisObject bgsaveerr;
    public static RedisObject masterdownerr;
    public static RedisObject roslaveerr;
    public static RedisObject execaborterr;
    public static RedisObject noautherr;
    public static RedisObject noreplicaserr;
    public static RedisObject busykeyerr;
    public static RedisObject oomerr;
    public static RedisObject plus;
    public static RedisObject messagebulk;
    public static RedisObject pmessagebulk;
    public static RedisObject subscribebulk;
    public static RedisObject unsubscribebulk;
    public static RedisObject psubscribebulk;
    public static RedisObject punsubscribebulk;
    public static RedisObject del;
    public static RedisObject rpop;
    public static RedisObject lpop;
    public static RedisObject lpush;
    public static RedisObject emptyscan;
    public static RedisObject minstring;
    public static RedisObject maxstring;
    public static RedisObject[] integers = new RedisObject[REDIS_SHARED_INTEGERS];
}
