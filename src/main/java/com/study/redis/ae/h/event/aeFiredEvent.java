package com.study.redis.ae.h.event;

import lombok.Data;

/**
 * @author chenxuegui
 * @since 2021.10.21
 *
 * 已就绪的文件事件
 */
@Data
public class aeFiredEvent implements Event {
    /**  已就绪文件描述符 */
    public int fd;

    /**  事件类型掩码
     *   AE_READABLE 或 AE_WRITABLE */
    public int mask;
}
