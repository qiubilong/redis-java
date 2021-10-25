package com.study.redis.ae.h;

import com.study.redis.ae.h.aeBeforeSleepProc;
import com.study.redis.ae.h.event.aeFileEvent;
import com.study.redis.ae.h.event.aeFiredEvent;
import com.study.redis.ae.h.event.aeTimeEvent;
import lombok.Data;

import java.util.List;

/**
 * @author chenxuegui
 * @since 2021.10.21
 *
 *  State of an event based program
 *  事件处理器的状态
 */
@Data
public class aeEventLoop {

    /**目前已注册的最大描述符
     * highest file descriptor currently registered */
    public int maxfd;

    /**目前已追踪的最大描述符
     * max number of file descriptors tracked  */
    public int setsize;

    // 用于生成时间事件 id
    public long timeEventNextId;

    // 最后一次执行时间事件的时间
    public long lastTime;

    /* Registered events
    * 已注册的文件事件  */
    public List<aeFileEvent> events;

    /*  Fired  events
     * 已就绪的文件事件  */
    public List<aeFiredEvent> fired;

    /** 时间事件 */
    public aeTimeEvent timeEventHead;

    /** 事件处理器的开关 */
    public boolean stop;

    /* This is used for polling API specific data
    *  多路复用库的私有数据
    * */
    public Object apidata;

    // 在处理事件前要执行的函数
    public aeBeforeSleepProc beforeSleep;





}
