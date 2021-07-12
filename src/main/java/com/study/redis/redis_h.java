package com.study.redis;

import lombok.Data;

import java.util.List;

/**
 * @author chenxuegui
 * @since 2021.07.12
 * redis 公共对象，常量定义
 */
public class redis_h {

    /** redis server对象 */
    @Data
    public static class redisServer{
        /** 配置文件绝对路径 */
        String configfile;

        /** serverCron每秒调用次数
         * serverCron() calls frequency in hertz*/
        int hz;

        /**数据库 */
        redisDb db;

        /** 命令表(有rename配置) */
        List<String> commands;
        /** 命令表(无rename配置) */
        List<String> orig_commands;
    }

    /** redis数据库
     * . There are multiple databases identified
     * by integers from 0 (the default database) up to the max configureddatabase
     * */
    @Data
    public static class redisDb{

    }
}
