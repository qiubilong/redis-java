package com.study.redis.redis.h;

/**
 * @author chenxuegui
 * @since 2021.07.23
 *  Error codes
 */
public enum ErrorCode {

    REDIS_OK(0),REDIS_ERR(-1);

    public int val;
    ErrorCode(int i) {
        val = i;
    }
}
