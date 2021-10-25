package com.study.redis.ae.h.event;

import com.study.redis.ae.h.aeFileProc;
import lombok.Data;

/**
 * @author chenxuegui
 * @since 2021.10.21
 *
 * File event structure
 * 文件事件结构
 */
@Data
public class aeFileEvent implements Event {

    /** 监听事件类型掩码
     * one of AE_(READABLE|WRITABLE) */
    public int mask;

    // 读事件处理器
    public aeFileProc rfileProc;

    // 写事件处理器
    public aeFileProc wfileProc;

    // 多路复用库的私有数据
    public  Object clientData;
}
