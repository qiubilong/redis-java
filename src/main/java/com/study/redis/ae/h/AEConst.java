package com.study.redis.ae.h;

/**
 * @author chenxuegui
 * @since 2021.10.25
 */
public class AEConst {


    /*
     * 文件事件状态
     */
    public  enum AE_FILE_STATUS{
        //未设置
        AE_NONE(0),
        //可读
        AE_READABLE(1),
        //可写
        AE_WRITABLE(2),

        ;

        public int val;

        AE_FILE_STATUS(int val) {
            this.val = val;
        }
    }


    /*
     * 时间处理器的执行 flags
     */
    public  enum AE_EVENT_TYPE{
        //文件事件
        AE_FILE_EVENTS(1),
        //时间事件
        AE_TIME_EVENTS(2),

        // 所有事件
        AE_ALL_EVENTS(AE_FILE_EVENTS.val|AE_TIME_EVENTS.val),

        // 不阻塞，也不进行等待
        AE_DONT_WAIT(4),

        ;

        public int val;

        AE_EVENT_TYPE(int val) {
            this.val = val;
        }
    }
}
