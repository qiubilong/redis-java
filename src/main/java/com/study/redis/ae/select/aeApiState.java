package com.study.redis.ae.select;

import com.study.redis.ae.h.aeEventLoop;
import lombok.Data;

/**
 * @author chenxuegui
 * @since 2021.10.25
 */
@Data
public class aeApiState {

    public int rfds, wfds;
    /* We need to have a copy of the fd sets as it's not safe to reuse
     * FD sets after select(). */
    public int _rfds, _wfds;


    public static void aeApiCreate(aeEventLoop eventLoop) {
        aeApiState state = new aeApiState();

        state.rfds = 0;
        state.wfds = 0;
        eventLoop.apidata = state;
    }
}
