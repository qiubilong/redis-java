package com.study.redis.redis.command;

import com.study.redis.redis.h.RedisClient;

/**
 * @author chenxuegui
 * @since 2021.07.30
 */
public enum  RedisGetKeysProc {
    sortGetKeys(){
        @Override
        void proc(RedisClient client) {

        }
    },

    zunionInterGetKeys(){
        @Override
        void proc(RedisClient client) {

        }
    },
    evalGetKeys(){
        @Override
        void proc(RedisClient client) {

        }
    },

    ;

    abstract void proc(RedisClient client);
}
