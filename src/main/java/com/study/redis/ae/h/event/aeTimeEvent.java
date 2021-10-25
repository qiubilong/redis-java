package com.study.redis.ae.h.event;

import com.study.redis.ae.h.aeTimeProc;
import lombok.Data;

/**
 * @author chenxuegui
 * @since 2021.10.21
 *Time event structure
 * 时间事件结构
 */
@Data
public class aeTimeEvent implements Event {
    /* time event identifier.
    * 时间事件的唯一标识符
    *  */
    public long id;

    // 事件的到达时间
    /* seconds */
    public long when_sec;
    /* milliseconds */
    public long when_ms;

    /** 事件处理函数 */
    public aeTimeProc timeProc;

    // 事件释放函数
    //aeEventFinalizerProc finalizerProc;

    /** 多路复用库的私有数据 */
    public Object clientData;


    /** 指向下个时间事件结构，形成链表 */
    public aeTimeEvent next;

}
