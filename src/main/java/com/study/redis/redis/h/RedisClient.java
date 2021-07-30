package com.study.redis.redis.h;

import lombok.Data;

/**
 * With multiplexing we need to take per-client state.
 * Clients are taken in a liked list.
 * 因为使用 io多路复用技术，需要保持每个客户端状态，客户端使用
 * 链表结构连接
 * ？？ 如果不使用多路复用，构建并发服务可使用：
 *  1、每客户端连接一个进程
 *  2、每个客户连接一个线程
 * */
@Data
public  class RedisClient {

}