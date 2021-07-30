package com.study.redis.redis.h;

import lombok.Data;

@Data
public  class ClientBufferLimitsConfig {
    // 硬限制
    public long hard_limit_bytes;
    // 软限制
    public  long soft_limit_bytes;
    // 软限制时限
    long soft_limit_seconds;

    public ClientBufferLimitsConfig(long hard_limit_bytes, long soft_limit_bytes, long soft_limit_seconds) {
        this.hard_limit_bytes = hard_limit_bytes;
        this.soft_limit_bytes = soft_limit_bytes;
        this.soft_limit_seconds = soft_limit_seconds;
    }
}