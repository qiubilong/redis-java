package com.study.redis;

/**
 * @author chenxuegui
 * @since 2021.07.12
 * 事件驱动程序库
 * A simple event-driven programming library. Originally I wrote this code
 *  * for the Jim's event-loop (Jim is a Tcl interpreter) but later translated
 *  * it in form of a library for easy reuse.
 */
public class ae_h {

    /** 事件驱动状态 */
    public static class aeEventLoop{
        /** 目前已经注册的最大描述符 */
        int maxfd;

        /** 目前已经追踪的最大描述符 */
        int setsize;
    }
}
