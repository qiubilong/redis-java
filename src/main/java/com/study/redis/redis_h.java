package com.study.redis;

import lombok.Data;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chenxuegui
 * @since 2021.07.12
 * redis 公共对象，常量定义
 */
public class redis_h {

    public static int REDIS_BINDADDR_MAX = 16;

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

        /** 事件状态 */
        ae_h.aeEventLoop el;

        /** 最近一次使用时钟 */
        int lrulock;

        /** 服务器关闭标志 */
        boolean shutdown_asap;

        /** serverCron在执行渐进式rehash */
        boolean activerehashing;

        /** 密码 */
        String requirepass;

        /** pid文件 */
        String pidFile;

        /** 架构类型 32 or 64 on sizeof(long) */
        int arch_bits;

        /** serverCron()运行次数 */
        int cronloops;

        /** 本服务id */
        int runid;

        /** sentinel模式 */
        boolean sentinel_model;





  /************************* 网络部分**************/
        /** tcp端口*/
        int port;

        /** tcp listen backlog*/
        int tcp_backlog;

        /** Addresses we should bind to */
        List<InetSocketAddress> bindaddr = new ArrayList<>(REDIS_BINDADDR_MAX);
        /** 绑定地址的数量 */
        int bindaddr_count;

        /** unix套接字
         * UNIX socket path
         * char *unixsocket;
         * UNIX socket permission
         * mode_t unixsocketperm;
         * */

        /** tcp文件描述符 */
        int[] ipfd = new int[REDIS_BINDADDR_MAX];
        /**  描述符数量 Used slots in ipfd[] */
        int ipfd_count;

        /** unix套接字描述符  Unix socket file descriptor */
        int sofd;

        /** Cluster bus listening socket */
        int[] cfd = new int[REDIS_BINDADDR_MAX];
        /* Used slots in cfd[] */
        int cfd_count;

        /** 客户端链表 */
        LinkedList<redisClient> clients = new LinkedList<>();

        /** 异步关闭的客户端 */
        LinkedList<redisClient> clients_to_close;

        /** 从服务器，监视器 */
        LinkedList<redisClient> slaves,monitors;

        /** 当前客户端，用于崩溃时报告 */
        redisClient current_client;

        /** True if clients are currently paused */
        boolean clients_paused;
        /** 客户端clients_paused暂停时间 */
        long clients_pause_end_time;

        /**网络错误*/
        char[] neterr = new char[256];

        /***
         *  dict *migrate_cached_sockets;
         */




        /******************RDB AOF loading信息 *******************/
        /* We are loading data from disk if true */
        boolean loading;
        /** 正在载入数据大小 */
        long loading_total_bytes;
        /** 已经载入数据大小 */
        long loading_loaded_bytes;
        /* 载入数据开始时间 */
        long loading_start_time;
        long loading_process_events_interval_bytes;

        /** 常用快捷命令 */
        redisCommand delCommand,lpushCommand,lpopCommand,ropCommand;





        /*********************统计部分*****************************/
        /** 服务器启动时间 */
        long stat_starttime;
        /** 已处理的命令的数量 */
        long stat_numcommands;
        /** 服务接到的连接请求数 */
        long stat_numconnections;
        /* 已过期的键数量 */
        long stat_expirekeys;
        /* 内存回收释放内存的key数量 */
        long stat_evictedkeys;

        /* 查找键成功的数量*/
        long stat_keyspace_hits;
        /* 查找键失败的数量*/
        long stat_keyspace_misses;

        /* 已经使用内存的峰值 */
        long stat_peak_memory;
        /** 最后一次执行fork的耗时 */
        long stat_fork_time;

        /**Clients rejected because of maxclients
         * 连接数过多二拒绝连接的数量 */
        long stat_rejected_conn;

        /** Number of full resyncs with slaves */
        long stat_sync_full;
        /*Number of accepted PSYNC requests.*/
        long stat_sync_partial_ok;
        long stat_sync_partial_err;




        /*******************show log 慢日志*****************************/
        /** 慢日志列表 */
        List<String> showlog;
        /** 当前慢日志查询 **/
        long slowlog_entry_id;
        /** 慢日志时间阈值 time limit */
        long slowlog_log_slower_than;
        /** SLOWLOG max number of items */
        long slowlog_max_len;

        int resident_set_size;

        /** qps抽样 */
        long ops_sec_last_sample_time;
        long ops_sec_last_sample_ops;
        /**抽样结果*/
        long[] ops_sec_samples = new long[16];
        /** 抽样结果索引 */
        int ops_sec_idx;


        /*********************服务配置configuraion********************************/
        /* 日志可见性 loglevel */
        int verbosity;

        /** 客户端空闲超时时间 client timeout in seconds */
        int maxidletime;

        /* 是否开启 so_keepalive*/
        int tcpkeepalive;
        /** client查询buffer length limit */
        int client_max_querybuf_len;
        /**数据库数量 */
        int dbnum;
        boolean daemonize;

        /** 普通，从服务器，pubsub客户端的输出缓冲区大小限制 */
        clientBufferLimitsConfig[] client_obuf_limits = new clientBufferLimitsConfig[3];



        /***********************AOF持久化**************************/
        /** aof状态 REDIS_AOF_(ON|OFF|WAIT_REWRITE)*/
        int aof_state;
        /** fsync策略(每个写入/每秒/从不) */
        int aof_fsync;
        /** aof文件名 */
        String aof_filename;
        int aof_no_fsync_on_rewrite;
        int aof_rewrite_perc;
        int aof_rewrite_min_size;

    }



    /** redis数据库
     * . There are multiple databases identified
     * by integers from 0 (the default database) up to the max configureddatabase
     * */
    @Data
    public static class redisDb{

    }

    /** redis 命令 */
    @Data
    public static class redisCommand{

    }


    /**
     * With multiplexing we need to take per-client state.
     * Clients are taken in a liked list.
     * 因为使用 io多路复用技术，需要保持每个客户端状态，客户端使用
     * 链表结构连接
     * ？？ 如果不使用多路复用，构建并发服务可使用：
     *  1、每客户端连接一个进程
     *  2、每个客户连接一个线程
     * */
    @Data
    public static class redisClient{

    }

    @Data
    public static class clientBufferLimitsConfig{

    }
}
