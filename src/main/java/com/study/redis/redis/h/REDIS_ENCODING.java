package com.study.redis.redis.h;

/**
 * @author chenxuegui
 * @since 2021.10.20
 * 对象编码
 */
public enum REDIS_ENCODING {
    /* Raw representation */
    REDIS_ENCODING_RAW(0),
    /* Encoded as integer */
    REDIS_ENCODING_INT(1),
    /* Encoded as hash table */
    REDIS_ENCODING_HT(2),
    /* Encoded as zipmap */
    REDIS_ENCODING_ZIPMAP(3),
    /* Encoded as regular linked list */
    REDIS_ENCODING_LINKEDLIST(4),
    /* Encoded as ziplist */
    REDIS_ENCODING_ZIPLIST(5),
    /* Encoded as intset */
    REDIS_ENCODING_INTSET(6),
    /* Encoded as skiplist */
    REDIS_ENCODING_SKIPLIST(7),
    /* Embedded sds string encoding */
    REDIS_ENCODING_EMBSTR(8),

    ;
    public int id;

    REDIS_ENCODING(int id) {
        this.id = id;
    }
}
