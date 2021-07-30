package com.study.redis.redis.h;

import com.study.redis.ae_h;
import com.study.redis.cluster_h;
import com.study.redis.dict.h.Dict;
import com.study.redis.dict_h;
import lombok.Data;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static com.study.redis.redis.h.ServerConf.REDIS_BINDADDR_MAX;
import static com.study.redis.redis.h.ServerConf.REDIS_CLIENT_LIMIT_NUM_CLASSES;

/**
 * redis server对象
 */
@Data
public class RedisServer {
    /**
     * 配置文件绝对路径
     */
    public String configfile;

    /**
     * serverCron每秒调用次数
     * serverCron() calls frequency in hertz
     */
    public int hz;

    /**
     * 数据库
     */
    public RedisDb db;

    /**
     * 命令表(有rename配置)
     */
    public Dict commands;
    /**
     * 命令表(无rename配置)
     */
    public Dict orig_commands;

    /**
     * 事件状态
     */
    public ae_h.aeEventLoop el;

    /**
     * 最近一次使用时钟
     */
    public long lruclock;

    /**
     * 服务器关闭标志
     */
    public boolean shutdown_asap;

    /**
     * serverCron在执行渐进式rehash
     */
    public int activerehashing;

    /**
     * 密码
     */
    public String requirepass;

    /**
     * pid文件
     */
    public String pidfile;

    /**
     * 架构类型 32 or 64 on sizeof(long)
     */
    public int arch_bits;

    /**
     * serverCron()运行次数
     */
    public int cronloops;

    /**
     * 本服务id
     */
    /* ID always different at every exec. */
    public String runid;

    /**
     * sentinel模式
     */
    public boolean sentinel_model;


    /************************* 网络部分**************/
    /**
     * tcp端口
     */
    public int port;

    /**
     * tcp listen backlog
     */
    public int tcp_backlog;

    /**
     * Addresses we should bind to
     */
    public List<InetSocketAddress> bindaddr = new ArrayList<>(REDIS_BINDADDR_MAX);
    /**
     * 绑定地址的数量
     */
    public int bindaddr_count;

    /** unix套接字
     * UNIX socket path
     * char *unixsocket;
     * UNIX socket permission
     * mode_t unixsocketperm;
     * */

    /**
     * tcp文件描述符
     */
    public int[] ipfd = new int[REDIS_BINDADDR_MAX];
    /**
     * 描述符数量 Used slots in ipfd[]
     */
    public int ipfd_count;

    /**
     * unix套接字描述符  Unix socket file descriptor
     */
    public int sofd;

    /**
     * Cluster bus listening socket
     */
    public int[] cfd = new int[REDIS_BINDADDR_MAX];
    /* Used slots in cfd[] */
    public int cfd_count;

    /**
     * 客户端链表
     */
    public List<RedisClient> clients = new LinkedList<>();

    /**
     * 异步关闭的客户端
     */
    public List<RedisClient> clients_to_close;

    /**
     * 从服务器，监视器
     */
    public List<RedisClient> slaves, monitors;

    /**
     * 当前客户端，用于崩溃时报告
     */
    public RedisClient current_client;

    /**
     * True if clients are currently paused
     */
    public boolean clients_paused;
    /**
     * 客户端clients_paused暂停时间
     */
    public long clients_pause_end_time;

    /**
     * 网络错误
     */
    public char[] neterr = new char[256];

    /***
     *  dict *migrate_cached_sockets;
     */


    /******************RDB AOF loading信息 *******************/
    /* We are loading data from disk if true */
    public boolean loading;
    /**
     * 正在载入数据大小
     */
    public long loading_total_bytes;
    /**
     * 已经载入数据大小
     */
    public long loading_loaded_bytes;
    /* 载入数据开始时间 */
    public long loading_start_time;
    public long loading_process_events_interval_bytes;

    /**
     * 常用快捷命令
     */
    public RedisCommand delCommand, lpushCommand, lpopCommand, ropCommand;


    /*********************统计部分*****************************/
    /**
     * 服务器启动时间
     */
    public long stat_starttime;
    /**
     * 已处理的命令的数量
     */
    public long stat_numcommands;
    /**
     * 服务接到的连接请求数
     */
    public long stat_numconnections;
    /* 已过期的键数量 */
    public long stat_expirekeys;
    /* 内存回收释放内存的key数量 */
    public long stat_evictedkeys;

    /* 查找键成功的数量*/
    public long stat_keyspace_hits;
    /* 查找键失败的数量*/
    public long stat_keyspace_misses;

    /* 已经使用内存的峰值 */
    public long stat_peak_memory;
    /**
     * 最后一次执行fork的耗时
     */
    public long stat_fork_time;

    /**
     * Clients rejected because of maxclients
     * 连接数过多二拒绝连接的数量
     */
    public long stat_rejected_conn;

    /**
     * Number of full resyncs with slaves
     */
    public long stat_sync_full;
    /*Number of accepted PSYNC requests.*/
    public long stat_sync_partial_ok;
    public long stat_sync_partial_err;


    /*******************show log 慢日志*****************************/
    /**
     * 慢日志列表
     */
    public List<String> showlog;
    /**
     * 当前慢日志查询
     **/
    public long slowlog_entry_id;
    /**
     * 慢日志时间阈值 time limit
     */
    public long slowlog_log_slower_than;
    /**
     * SLOWLOG max number of items
     */
    public long slowlog_max_len;

    public int resident_set_size;

    /**
     * qps抽样
     */
    public long ops_sec_last_sample_time;
    public long ops_sec_last_sample_ops;
    /**
     * 抽样结果
     */
    public long[] ops_sec_samples = new long[16];
    /**
     * 抽样结果索引
     */
    public int ops_sec_idx;


    /*********************服务配置configuraion********************************/
    /* 日志可见性 loglevel */
    public int verbosity;

    /**
     * 客户端空闲超时时间 client timeout in seconds
     */
    public int maxidletime;

    /* 是否开启 so_keepalive*/
    public int tcpkeepalive;
    /**
     * 是否开启周期性清理过期key
     */
    public int active_expire_enabled;
    /**
     * client查询buffer length limit
     */
    public int client_max_querybuf_len;
    /**
     * 数据库数量
     */
    public int dbnum;
    public boolean daemonize;

    /**
     * 普通，从服务器，pubsub客户端的输出缓冲区大小限制
     */
    public ClientBufferLimitsConfig[] client_obuf_limits = new ClientBufferLimitsConfig[REDIS_CLIENT_LIMIT_NUM_CLASSES];


    /***********************AOF持久化**************************/
    /**
     * aof状态 REDIS_AOF_(ON|OFF|WAIT_REWRITE)
     */
    public int aof_state;
    /**
     * fsync策略(每个写入/每秒/从不)
     */
    public int aof_fsync;
    /**
     * aof文件名
     */
    public String aof_filename;
    public int aof_no_fsync_on_rewrite;
    /* Rewrite AOF if % growth is > M and... */
    public int aof_rewrite_perc;
    /* the AOF file is at least N bytes. */
    public int aof_rewrite_min_size;
    /* AOF size on latest startup or rewrite. */
    public long aof_rewrite_base_size;
    public long aof_current_size;
    public int aof_rewrite_scheduled;
    /***  负责进行 AOF 重写的子进程 ID */
    public int aof_child_pid;

    /**
     * AOF重写缓冲区列表
     * Hold changes during an AOF rewrite. *
     */
    public LinkedList<String> aof_rewrite_buf_blocks;
    /**
     * AOF缓冲区
     * written before entering the event loop
     */
    public String aof_buf;
    /**
     * aof文件描述符
     */
    public int aof_fd;
    /**
     * AOF选择的数据库
     */
    public int aof_selected_db;
    /* UNIX time of postponed AOF flush */
    public long aof_flush_postponed_start;

    /**
     * 最后一次执行fsync时间
     */
    public long aof_last_fsync;
    /**
     * 上次执行 aof rewrite的时间
     */
    public long aof_rewrite_time_last;
    /**
     * aof_rewrite执行的开始时间
     * Current AOF rewrite start time
     */
    public long aof_rewrite_time_start;
    /**
     * 最后一次执行 BGREWRITEAOF 的结果
     * REDIS_OK or REDIS_ERR
     */
    public int aof_lastbgrewrite_status;

    /* delayed AOF fsync() counter */
    public int aof_delayed_fsync;

    /**
     * 配置主动fsync的条件
     */
    /* fsync incrementally while rewriting? */
    public int aof_rewrite_incremental_fsync;
    /* REDIS_OK or REDIS_ERR */
    public int aof_last_write_status;
    /* Valid if aof_last_write_status is ERR */
    public int aof_last_write_errno;


    /*****************RDB persistence（PDB持久化）*****************/

    /**
     * 上次执行save()后，数据修改次数
     * Changes to DB from the last save
     */
    public long dirty;

    /* BGSAVE 执行前的数据库被修改次数
     * Used to restore dirty on failed BGSAVE */
    public long dirty_before_bgsave;

    /* PID of RDB saving child
     * 负责执行 BGSAVE 的子进程的 ID,没在执行 BGSAVE 时，设为 -1
     *  */
    public long rdb_child_pid;
    /**
     * 主动执行bgsave()的条件
     */
    public List<SaveParam> saveparams = new ArrayList<>();
    public int saveparamslen;

    /* Name of RDB file */
    public String rdb_filename;
    /* Use compression in RDB */
    public int rdb_compression;
    /* Use RDB checksum */
    public int rdb_checksum;

    /* Unix time of last successful save
     * 最后一次完成 SAVE 的时间 */
    public long lastsave;

    /* Unix time of last attempted bgsave
    最后一次尝试执行 BGSAVE 的时间
    *  */
    public long lastbgsave_try;

    /* Time used by last RDB save run.
     *  上次执行bgsave()消耗时间
     *  */
    public long rdb_save_time_last;

    /* Current RDB save start time.
     * 当前bgsave()开始执行时间
     * */
    public long rdb_save_time_start;

    /* REDIS_OK or REDIS_ERR
     * 上次执行bgsave()的状态 */
    public int lastbgsave_status;
    /* Don't allow writes if can't BGSAVE
     * 执行bgsave()错误时是否停止数据写入 */
    public int stop_writes_on_bgsave_err;

    /* Propagation of commands in AOF / replication */
    //redisOpArray also_propagate;    /* Additional command to propagate. */


    /****************************Logging 日志****************************** */
    /* Path of log file */
    public String logfile;
    /* Is syslog enabled? */
    public boolean syslog_enabled;
    /* Syslog ident */
    public String syslog_ident;
    /* Syslog facility */
    public int syslog_facility;


    /************************** 复制备份Replication (master) **********************/

    /* Last SELECTed DB in replication output */
    public int slaveseldb;
    /* Global replication offset
     * 全局复制偏移量（一个累计值）
     *  */
    public long master_repl_offset;
    /* Master pings the slave every N seconds
     * */
    public int repl_ping_slave_period;

    /* Replication backlog for partial syncs */
    public String repl_backlog;
    /* Backlog circular buffer size */
    public long repl_backlog_size;
    /* Backlog actual data length
     * backlog 中数据的长度 */
    public long repl_backlog_histlen;
    /* Backlog circular buffer current offset
     backlog 的当前索引 */
    public long repl_backlog_idx;
    // backlog 中可以被还原的第一个字节的偏移量
    /* Replication offset of first byte in the backlog buffer. */
    public long repl_backlog_off;
    // backlog 的过期时间
    public long repl_backlog_time_limit; /* Time without slaves after the backlog
                                       gets released. */

    // 距离上一次没有从服务器的时间
    public long repl_no_slaves_since;    /* We have no slaves since that time.
                                       Only valid if server.slaves len is 0. */

    // 是否开启最小数量从服务器写入功能
    public int repl_min_slaves_to_write;   /* Min number of slaves to write. */
    // 定义最小数量从服务器的最大延迟值
    public int repl_min_slaves_max_lag;    /* Max lag of <count> slaves to write. */
    // 延迟良好的从服务器的数量
    public int repl_good_slaves_count;     /* Number of slaves with lag <= max_lag. */


    /****************************复制从 Replication (slave) *************************/
    /* AUTH with this password with master
     * 主服务器的验证密码 */
    public String masterauth;
    /* Hostname of master
     * 主服务器的地址 */
    public String masterhost;
    /* Port of master */
    public int masterport;
    /* Timeout after N seconds of master idle */
    public int repl_timeout;
    /* Client that is master for this slave 主服务器
     * */
    public RedisClient master;
    // 被缓存的主服务器，PSYNC 时使用
    /* Cached master to be reused for PSYNC. */
    public RedisClient cached_master;
    /* Timeout for synchronous I/O calls */
    public int repl_syncio_timeout;
    /* Replication status if the instance is a slave */
    public int repl_state;
    /* Size of RDB to read from master during sync. */
    public long repl_transfer_size;
    /* Amount of RDB read from master during sync.
     * 已读 RDB 文件内容的字节数 */
    public long repl_transfer_read;
    /* Offset when we fsync-ed last time.
     *   最近一次执行 fsync 时的偏移量
     *  用于 sync_file_range 函数
     *  */
    public long repl_transfer_last_fsync_off;
    /* Slave -> Master SYNC socket
     * 主服务器的套接字 */
    public int repl_transfer_s;
    /* Slave -> Master SYNC temp file descriptor
     * 保存 RDB 文件的临时文件的描述符 */
    public int repl_transfer_fd;
    /* Slave-> master SYNC temp file name
     * 保存 RDB 文件的临时文件名字 */
    public String repl_transfer_tmpfile;
    /* Unix time of the latest read, for timeout
     * 最近一次读入 RDB 内容的时间 */
    public long repl_transfer_lastio;
    /* Serve stale data when link is down? */
    public int repl_serve_stale_data;
    /* Slave is read only? */
    public int repl_slave_ro;
    /* Unix time at which link with master went down */
    public long repl_down_since;
    /* Disable TCP_NODELAY after SYNC? */
    public int repl_disable_tcp_nodelay;
    /* Reported in INFO and used by Sentinel. */
    public int slave_priority;
    // 本服务器（从服务器）当前主服务器的 RUN ID
    /* Master run id for PSYNC. */
    public char[] repl_master_runid = new char[40 + 1];
    /* Master PSYNC offset. */
    public long repl_master_initial_offset;


    /*************************复制脚本缓存 Replication script cache. ******************/
    // 复制脚本缓存
    // 字典
    //dict *repl_scriptcache_dict;        /* SHA1 all slaves are aware of. */
    // FIFO 队列
    //list *repl_scriptcache_fifo;        /* First in, first out LRU eviction. */
    // 缓存的大小
    public int repl_scriptcache_size;          /* Max number of elements. */

    /* Synchronous replication. */
    //list *clients_waiting_acks;         /* Clients waiting in WAIT command. */
    public int get_ack_from_slaves;            /* If true we send REPLCONF GETACK. */


    /***************** Limits *********************************************/
    /* Max number of simultaneous clients
     * 同时在线的最大客户端数
     * */
    public int maxclients;
    /* Max number of memory bytes to use
     *最大内存字节数
     * */
    public long maxmemory;
    /* Policy for key eviction 内存耗尽时采用策略*/
    public int maxmemory_policy;
    /* Pricision of random sampling */
    public int maxmemory_samples;


    /* Blocked clients */
    /* Number of clients blocked by lists */
    public int bpop_blocked_clients;
    /* list of clients to unblock before next loop */
    public List<RedisClient> unblocked_clients;
    /* List of readyList structures for BLPOP & co */
    public List<String> ready_keys;


    /* Sort parameters - qsort_r() is only available under BSD so we
     * have to take this state global, in order to pass it to sortCompare() */
    public int sort_desc;
    public int sort_alpha;
    public int sort_bypattern;
    public int sort_store;


    /* Zip数据结构配置 Zip structure config, see redis.conf for more information  */
    public int hash_max_ziplist_entries;
    public int hash_max_ziplist_value;
    public int list_max_ziplist_entries;
    public int list_max_ziplist_value;
    public int set_max_intset_entries;
    public int zset_max_ziplist_entries;
    public int zset_max_ziplist_value;
    public int hll_sparse_max_bytes;

    /* Unix time sampled every cron cycle. */
    public long unixtime;
    /* Like 'unixtime' but with milliseconds resolution. */
    public long mstime;


    /* Pubsub */
    // 字典，键为频道，值为链表
    // 链表中保存了所有订阅某个频道的客户端
    // 新客户端总是被添加到链表的表尾
    //dict *pubsub_channels;  /* Map channels to list of subscribed clients */

    // 这个链表记录了客户端订阅的所有模式的名字
    //list *pubsub_patterns;  /* A list of pubsub_patterns */

    public int notify_keyspace_events; /* Events to propagate via Pub/Sub. This is an
                                   xor of REDIS_NOTIFY... flags. */


    /****************************集群 Cluster ***********************************/
    /* 是否开启集群 Is cluster enabled? */
    public int cluster_enabled;
    /* Cluster node timeout. */
    public long cluster_node_timeout;
    /* Cluster auto-generated config file name. */
    public String cluster_configfile;

    /* 集群状态State of the cluster */
    public cluster_h.clusterState cluster;

    public int cluster_migration_barrier; /* Cluster replicas migration barrier. */
    /* Scripting */

    // Lua 环境
    //lua_State *lua; /* The Lua interpreter. We use just one for all clients */

    // 复制执行 Lua 脚本中的 Redis 命令的伪客户端
    /* The "fake client" to query Redis from Lua */
    public RedisClient lua_client;

    // 当前正在执行 EVAL 命令的客户端，如果没有就是 NULL
    /* The client running EVAL right now, or NULL */
    public RedisClient lua_caller;

    // 一个字典，值为 Lua 脚本，键为脚本的 SHA1 校验和
    /* A dictionary of SHA1 -> Lua scripts */
    public dict_h.dict lua_scripts;
    // Lua 脚本的执行时限
    /* Script timeout in milliseconds */
    public long lua_time_limit;
    // 脚本开始执行的时间
    /* Start time of script, milliseconds time */
    public long lua_time_start;

    // 脚本是否执行过写命令
        /* True if a write command was called during the
                             execution of the current script. */
    public int lua_write_dirty;

    // 脚本是否执行过带有随机性质的命令
         /* True if a random command was called during the
                             execution of the current script. */
    public int lua_random_dirty;

    // 脚本是否超时
         /* True if we reached the time limit for script
                             execution. */
    public int lua_timedout;

    // 是否要杀死脚本
    /* Kill the script if true. */
    public int lua_kill;


    /******bug报告************ Assert & bug reporting************* */

    public String assert_failed;
    public String assert_file;
    public int assert_line;
    public int bug_report_start; /* True if bug report header was already logged. */
    public int watchdog_period;  /* Software watchdog period in ms. 0 = off */
}