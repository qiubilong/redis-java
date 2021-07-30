package com.study.redis.redis.h;

import lombok.Data;

/** 服务器自动执行bgsave()的条件*/
@Data
public  class SaveParam {
    /** 多少秒 */
    int seconds;
    /** 修改次数*/
    int changes;

    public SaveParam(int seconds, int changes) {
        this.seconds = seconds;
        this.changes = changes;
    }
}