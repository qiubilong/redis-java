package com.study.redis.redis;

import com.study.redis.dict.h.DictH;
import com.study.redis.redis.h.RedisServer;
import com.study.redis.redis.h.SaveParam;

import java.util.UUID;

import static com.study.redis.cluster.h.ClusterConf.REDIS_CLUSTER_DEFAULT_MIGRATION_BARRIER;
import static com.study.redis.cluster.h.ClusterConf.REDIS_CLUSTER_DEFAULT_NODE_TIMEOUT;
import static com.study.redis.dict.h.DictH.dictCreate;
import static com.study.redis.dict.h.DictType.commandTableDictType;
import static com.study.redis.redis.h.AOFStates.REDIS_AOF_OFF;
import static com.study.redis.redis.h.ErrorCode.REDIS_OK;
import static com.study.redis.redis.h.ServerConf.*;

/**
 * @author chenxuegui
 * @since 2021.07.12
 * redis-server启动入口，生命从这里起源
 */
public class Redis {


    /**** 全局声明***/
    public static RedisServer server = new RedisServer();

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

        //设置服务器id
        server.runid = UUID.randomUUID().toString();
        //定时器频率
        server.hz = REDIS_DEFAULT_HZ;
        server.arch_bits = 64;
        //tcp端口
        server.port = REDIS_SERVERPORT;
        //tcp连接队列
        server.tcp_backlog = REDIS_TCP_BACKLOG;
        //数据库数量
        server.dbnum = REDIS_DEFAULT_DBNUM;
        //client空闲超时时间
        server.maxidletime = REDIS_MAXIDLETIME;
        //是否开启tcp keepalive
        server.tcpkeepalive = REDIS_DEFAULT_TCP_KEEPALIVE;

        server.active_expire_enabled =1;
        //客户端请求缓冲区最大值 1G
        server.client_max_querybuf_len = REDIS_MAX_QUERYBUF_LEN;
        //是否正在从磁盘载入数据
        server.loading = false;

        server.aof_state = REDIS_AOF_OFF.ordinal();
        //持久化日志文件每秒刷盘
        server.aof_fsync = REDIS_DEFAULT_AOF_FSYNC;
        //aof rewrite时不刷盘
        server.aof_no_fsync_on_rewrite = REDIS_DEFAULT_AOF_NO_FSYNC_ON_REWRITE;
        // Rewrite AOF if % growth is > M and... 大小增长值>100%时执行rewite压缩
        server.aof_rewrite_perc = REDIS_AOF_REWRITE_PERC;
        //执行 aof rewrite的文件最小值64M
        server.aof_rewrite_min_size = REDIS_AOF_REWRITE_MIN_SIZE;

        //  最后一次执行 BGREWRITEAOF 时， AOF 文件的大小
        server.aof_rewrite_base_size = 0;
        // Rewrite once BGSAVE terminates.开启该选项时，BGSAVE结束时，触发rewrite
        server.aof_rewrite_scheduled = 0;
        // 最近一次aof进行fsync的时间
        server.aof_last_fsync = -1;
        // 最近一次aof重写，消耗的时间
        server.aof_rewrite_time_last = -1;
        //  Current AOF rewrite start time.
        server.aof_rewrite_time_start = -1;
        // 最后一次执行 BGREWRITEAOF 的结果
        server.aof_lastbgrewrite_status = REDIS_OK.val;
        // 记录 AOF 的 fsync 操作被推迟了多少次
        server.aof_delayed_fsync = 0;
        //  File descriptor of currently selected AOF file
        server.aof_fd = -1;
        // AOF 的当前目标数据库
        server.aof_selected_db = -1; /* Make sure the first time will not match */
        // UNIX time of postponed AOF flush
        server.aof_flush_postponed_start = 0;
        // fsync incrementally while rewriting? 重写过程中，增量触发fsync
        server.aof_rewrite_incremental_fsync = REDIS_DEFAULT_AOF_REWRITE_INCREMENTAL_FSYNC;
        // pid文件
        server.pidfile = (REDIS_DEFAULT_PID_FILE);
        // rdb 文件名
        server.rdb_filename = (REDIS_DEFAULT_RDB_FILENAME);
        // aof 文件名
        server.aof_filename = (REDIS_DEFAULT_AOF_FILENAME);

        // 是否要密码
        server.requirepass = null;
        // 是否进行rdb压缩
        server.rdb_compression = REDIS_DEFAULT_RDB_COMPRESSION;
        // rdb checksum
        server.rdb_checksum = REDIS_DEFAULT_RDB_CHECKSUM;
        // bgsave失败，停止写入
        server.stop_writes_on_bgsave_err = REDIS_DEFAULT_STOP_WRITES_ON_BGSAVE_ERROR;
        // 在执行 serverCron() 时进行渐进式 rehash
        server.activerehashing = REDIS_DEFAULT_ACTIVE_REHASHING;

        server.notify_keyspace_events = 0;
        // 支持的最大客户端数量 1万
        server.maxclients = REDIS_MAX_CLIENTS;
        // bpop阻塞的客户端
        server.bpop_blocked_clients = 0;
        // 可以使用的最大内存
        server.maxmemory = REDIS_DEFAULT_MAXMEMORY;
        // 内存淘汰策略，也就是key的过期策略，内存满后写操作直接返回错误码
        server.maxmemory_policy = REDIS_DEFAULT_MAXMEMORY_POLICY;
        server.maxmemory_samples = REDIS_DEFAULT_MAXMEMORY_SAMPLES;

        // hash表的元素小于这个值时，使用ziplist 编码模式; 512*64=32k
        server.hash_max_ziplist_entries = REDIS_HASH_MAX_ZIPLIST_ENTRIES;
        server.hash_max_ziplist_value = REDIS_HASH_MAX_ZIPLIST_VALUE;

        server.list_max_ziplist_entries = REDIS_LIST_MAX_ZIPLIST_ENTRIES;
        server.list_max_ziplist_value = REDIS_LIST_MAX_ZIPLIST_VALUE;
        server.set_max_intset_entries = REDIS_SET_MAX_INTSET_ENTRIES;
        server.zset_max_ziplist_entries = REDIS_ZSET_MAX_ZIPLIST_ENTRIES;
        server.zset_max_ziplist_value = REDIS_ZSET_MAX_ZIPLIST_VALUE;
        server.hll_sparse_max_bytes = REDIS_DEFAULT_HLL_SPARSE_MAX_BYTES;
        // 该标识打开时，表示正在关闭服务器
        server.shutdown_asap = false;

        // 复制相关
        server.repl_ping_slave_period = REDIS_REPL_PING_SLAVE_PERIOD;
        server.repl_timeout = REDIS_REPL_TIMEOUT;
        server.repl_min_slaves_to_write = REDIS_DEFAULT_MIN_SLAVES_TO_WRITE;
        server.repl_min_slaves_max_lag = REDIS_DEFAULT_MIN_SLAVES_MAX_LAG;
        // cluster模式相关
        server.cluster_enabled = 0;
        server.cluster_node_timeout = REDIS_CLUSTER_DEFAULT_NODE_TIMEOUT;
        server.cluster_migration_barrier = REDIS_CLUSTER_DEFAULT_MIGRATION_BARRIER;
        server.cluster_configfile = REDIS_DEFAULT_CLUSTER_CONFIG_FILE;
        // lua脚本
        server.lua_caller = null;
        server.lua_time_limit = REDIS_LUA_TIME_LIMIT;
        server.lua_client = null;
        server.lua_timedout = 0;
        //
        // server.migrate_cached_sockets = dictCreate(&migrateCacheDictType, NULL);
        server.loading_process_events_interval_bytes = (1024 * 1024 * 2);

        // 初始化 LRU 时间
        server.lruclock = getLRUClock();

        // rdb的默认保存策略
        appendServerSaveParams(60 * 60, 1);  /* save after 1 hour and 1 change */
        appendServerSaveParams(300, 100);  /* save after 5 minutes and 100 changes */
        appendServerSaveParams(60, 10000); /* save after 1 minute and 10000 changes */

        /* Replication related */
        // 初始化和复制相关的状态
        server.masterauth = null;
        server.masterhost = null;
        server.masterport = 6379;
        server.master = null;
        server.cached_master = null;
        server.repl_master_initial_offset = -1;
        server.repl_state = REDIS_REPL_NONE;
        server.repl_syncio_timeout = REDIS_REPL_SYNCIO_TIMEOUT;
        server.repl_serve_stale_data = REDIS_DEFAULT_SLAVE_SERVE_STALE_DATA;
        server.repl_slave_ro = REDIS_DEFAULT_SLAVE_READ_ONLY;
        server.repl_down_since = 0; /* Never connected, repl is down since EVER. */
        server.repl_disable_tcp_nodelay = REDIS_DEFAULT_REPL_DISABLE_TCP_NODELAY;
        server.slave_priority = REDIS_DEFAULT_SLAVE_PRIORITY;
        server.master_repl_offset = 0;

        /* Replication partial resync backlog */
        // 初始化 PSYNC 命令所使用的 backlog
        server.repl_backlog = null;
        server.repl_backlog_size = REDIS_DEFAULT_REPL_BACKLOG_SIZE;
        server.repl_backlog_histlen = 0;
        server.repl_backlog_idx = 0;
        server.repl_backlog_off = 0;
        server.repl_backlog_time_limit = REDIS_DEFAULT_REPL_BACKLOG_TIME_LIMIT;
        server.repl_no_slaves_since = System.currentTimeMillis()/1000;

        /* Client output buffer limits */
        // 设置客户端的输出缓冲区限制
        for (int j = 0; j < REDIS_CLIENT_LIMIT_NUM_CLASSES; j++)
           // server.client_obuf_limits[j] = clientBufferLimitsDefaults[j];

        /* Double constants initialization */
        // 初始化浮点常量
        R_Zero = 0.0;
        R_PosInf = 1.0 / R_Zero;
        R_NegInf = -1.0 / R_Zero;
        R_Nan = R_Zero / R_Zero;

        /* Command table -- we initiialize it here as it is part of the
         * initial configuration, since command names may be changed via
         * redis.conf using the rename-command directive. */
        // 初始化命令表
        // 在这里初始化是因为接下来读取 .conf 文件时可能会用到这些命令
        server.commands = dictCreate(commandTableDictType, null);
        server.orig_commands = dictCreate(commandTableDictType, null);
        //populateCommandTable();
        //server.delCommand = lookupCommandByCString("del");
        //server.multiCommand = lookupCommandByCString("multi");
       // server.lpushCommand = lookupCommandByCString("lpush");
        //server.lpopCommand = lookupCommandByCString("lpop");
        //server.rpopCommand = lookupCommandByCString("rpop");

        /* Slow log */
        // 初始化慢查询日志
        server.slowlog_log_slower_than = REDIS_SLOWLOG_LOG_SLOWER_THAN;
        server.slowlog_max_len = REDIS_SLOWLOG_MAX_LEN;

        /* Debugging */
        // 初始化调试项
        server.assert_failed = "<no assertion failed>";
        server.assert_file = "<no file>";
        server.assert_line = 0;
        server.bug_report_start = 0;
        server.watchdog_period = 0;


    }

    private static void appendServerSaveParams(int seconds, int changes) {
        server.saveparams.add(new SaveParam(seconds,changes));
        server.saveparamslen = server.saveparams.size();
    }

    private static long getLRUClock() {

        return (System.currentTimeMillis() /REDIS_LRU_CLOCK_RESOLUTION) & REDIS_LRU_CLOCK_MAX;
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
