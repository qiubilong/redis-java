package com.study.redis.redis.h;

import lombok.Data;

/**
 * @author chenxuegui
 * @since 2021.10.20
 * 数据类型-String
 * simple dynamic string
 */
@Data
public class SDShdr {

    /** buf中，已用空间长度 */
    protected int len;

    /** buf中，剩余可用空间长度 */
    protected int free;

    protected char[] buf;
}
