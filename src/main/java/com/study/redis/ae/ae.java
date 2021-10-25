package com.study.redis.ae;

import com.study.redis.ae.h.aeEventLoop;

import java.util.ArrayList;

import static com.study.redis.ae.h.AEConst.AE_FILE_STATUS.AE_NONE;
import static com.study.redis.ae.select.aeApiState.aeApiCreate;

/**
 * @author chenxuegui
 * @since 2021.10.21
 *
 *  * 事件驱动程序库
 *  * A simple event-driven programming library. Originally I wrote this code
 *  *  * for the Jim's event-loop (Jim is a Tcl interpreter) but later translated
 *  *  * it in form of a library for easy reuse.
 *
 */
public class ae {

    /**
     * 初始化事件处理器状态
     * @param setsize 最大描述符
     */
    public static aeEventLoop aeCreateEventLoop(int setsize){
        aeEventLoop eventLoop = new aeEventLoop();

        eventLoop.events = new ArrayList<>(setsize);
        eventLoop.fired = new ArrayList<>(setsize);
        eventLoop.setsize = setsize;
        eventLoop.lastTime = System.currentTimeMillis();


        eventLoop.timeEventNextId = 0;
        eventLoop.stop = false;
        eventLoop.maxfd = -1;
        eventLoop.beforeSleep = null;

        aeApiCreate(eventLoop);

        for (int i = 0; i < eventLoop.events.size(); i++) {
            eventLoop.events.get(i).mask = AE_NONE.val;
        }

        return eventLoop;
    }
}
