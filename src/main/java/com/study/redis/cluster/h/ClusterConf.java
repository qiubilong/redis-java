package com.study.redis.cluster.h;

/**
 * @author chenxuegui
 * @since 2021.07.27
 * Redis cluster data structures, defines
 */
public class ClusterConf {

    // 槽数量
    public static int REDIS_CLUSTER_SLOTS = 16384;
    // 集群在线
    public static int REDIS_CLUSTER_OK = 0;        /* Everything looks ok */
    // 集群下线
    public static int REDIS_CLUSTER_FAIL = 1;     /* The cluster can't work */
    // 节点名字的长度
    public static int REDIS_CLUSTER_NAMELEN = 40;   /* sha1 hex length */
    // 集群的实际端口号 = 用户指定的端口号 + REDIS_CLUSTER_PORT_INCR
    public static int REDIS_CLUSTER_PORT_INCR = 10000; /* Cluster port = baseport + PORT_INCR */

    /* The following defines are amunt of time, sometimes expressed as
     * multiplicators of the node timeout value (when ending with MULT).
     *
     * 以下是和时间有关的一些常量，
     * 以 _MULTI 结尾的常量会作为时间值的乘法因子来使用。
     */
// 默认节点超时时限
    public static int REDIS_CLUSTER_DEFAULT_NODE_TIMEOUT = 15000;
    // 检验下线报告的乘法因子
    public static int REDIS_CLUSTER_FAIL_REPORT_VALIDITY_MULT = 2;/* Fail report validity. */
    // 撤销主节点 FAIL 状态的乘法因子
    public static int REDIS_CLUSTER_FAIL_UNDO_TIME_MULT = 2;/* Undo fail if master is back. */
    // 撤销主节点 FAIL 状态的加法因子
    public static int REDIS_CLUSTER_FAIL_UNDO_TIME_ADD = 10; /* Some additional time. */
    // 在检查从节点数据是否有效时使用的乘法因子
    public static int REDIS_CLUSTER_SLAVE_VALIDITY_MULT = 10; /* Slave data validity. */
    // 在执行故障转移之前需要等待的秒数，似乎已经废弃
    public static int REDIS_CLUSTER_FAILOVER_DELAY = 5; /* Seconds */
    // 未使用，似乎已经废弃
    public static int REDIS_CLUSTER_DEFAULT_MIGRATION_BARRIER = 1;
    // 在进行手动的故障转移之前，需要等待的超时时间
    public static int REDIS_CLUSTER_MF_TIMEOUT = 5000; /* Milliseconds to do a manual failover. */
    // 未使用，似乎已经废弃
    public static int REDIS_CLUSTER_MF_PAUSE_MULT = 2;/* Master pause manual failover mult. */

    /* Redirection errors returned by getNodeByQuery(). */
    /* 由 getNodeByQuery() 函数返回的转向错误。 */
// 节点可以处理这个命令
    public static int REDIS_CLUSTER_REDIR_NONE = 0;       /* Node can serve the request. */
    // 键在其他槽
    public static int REDIS_CLUSTER_REDIR_CROSS_SLOT = 1;  /* Keys in different slots. */
    // 键所处的槽正在进行 reshard
    public static int REDIS_CLUSTER_REDIR_UNSTABLE = 2;  /* Keys in slot resharding. */
    // 需要进行 ASK 转向
    public static int REDIS_CLUSTER_REDIR_ASK = 3;     /* -ASK redirection required. */
    // 需要进行 MOVED 转向
    public static int REDIS_CLUSTER_REDIR_MOVED = 4;    /* -MOVED redirection required. */
}
