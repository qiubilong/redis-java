package com.study.redis;

/**
 * @author chenxuegui
 * @since 2021.07.12
 * redis-server启动入口，生命从这里起源
 */
public class redis {

    public static void main(String[] args) {

        //初始化服务器
        initServerConfig();

        //载入配置文件
        loadServerConfig();

        //创建初始化服务器数据结构
        initServer();

        //运行时间处理器，直到服务器关闭
        aeMain();

        //服务器关闭，停止事件循环
        aeDeleteEventLoop();
    }



    private static void initServerConfig() {

    }

    private static void loadServerConfig() {

    }


    private static void aeDeleteEventLoop() {

    }

    private static void aeMain() {

    }

    private static void initServer() {

    }


    public static void redisLog(Object obj){
        System.out.println(obj);
    }
}
