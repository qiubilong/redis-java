package com.study.redis.redis.command;

import com.study.redis.redis.h.RedisClient;
import com.study.redis.redis.h.RedisCommand;
import lombok.Data;

import static com.study.redis.redis.command.RedisGetKeysProc.*;


/**
 * @author chenxuegui
 * @since 2021.07.30
 */
public enum RedisCommandProc {

    getCommand("get", 2, "r", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    setCommand("set", -3, "wm", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    setnxCommand("setnx", 3, "wm", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    setexCommand("setex", 4, "wm", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    psetexCommand("psetex", 4, "wm", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    appendCommand("append", 3, "wm", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    strlenCommand("strlen", 2, "r", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    delCommand("del", -2, "w", null, 1, -1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    existsCommand("exists", 2, "r", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    setbitCommand("setbit", 4, "wm", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    getbitCommand("getbit", 3, "r", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    setrangeCommand("setrange", 4, "wm", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    getrangeCommand("getrange", 4, "r", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    getrangeCommand2("substr", 4, "r", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    incrCommand("incr", 2, "wm", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    decrCommand("decr", 2, "wm", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    mgetCommand("mget", -2, "r", null, 1, -1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    rpushCommand("rpush", -3, "wm", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    lpushCommand("lpush", -3, "wm", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    rpushxCommand("rpushx", 3, "wm", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    lpushxCommand("lpushx", 3, "wm", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    linsertCommand("linsert", 5, "wm", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    rpopCommand("rpop", 2, "w", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    lpopCommand("lpop", 2, "w", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    brpopCommand("brpop", -3, "ws", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    brpoplpushCommand("brpoplpush", 4, "wms", null, 1, 2, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    blpopCommand("blpop", -3, "ws", null, 1, -2, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    llenCommand("llen", 2, "r", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    lindexCommand("lindex", 3, "r", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    lsetCommand("lset", 4, "wm", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    lrangeCommand("lrange", 4, "r", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    ltrimCommand("ltrim", 4, "w", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    lremCommand("lrem", 4, "w", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    rpoplpushCommand("rpoplpush", 3, "wm", null, 1, 2, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    saddCommand("sadd", -3, "wm", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    sremCommand("srem", -3, "w", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    smoveCommand("smove", 4, "w", null, 1, 2, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    sismemberCommand("sismember", 3, "r", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    scardCommand("scard", 2, "r", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    spopCommand("spop", 2, "wRs", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    srandmemberCommand("srandmember", -2, "rR", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    sinterCommand("sinter", -2, "rS", null, 1, -1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    sinterstoreCommand("sinterstore", -3, "wm", null, 1, -1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    sunionCommand("sunion", -2, "rS", null, 1, -1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    sunionstoreCommand("sunionstore", -3, "wm", null, 1, -1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    sdiffCommand("sdiff", -2, "rS", null, 1, -1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    sdiffstoreCommand("sdiffstore", -3, "wm", null, 1, -1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    sinterCommand2("smembers", 2, "rS", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    sscanCommand("sscan", -3, "rR", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    zaddCommand("zadd", -4, "wm", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    zincrbyCommand("zincrby", 4, "wm", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    zremCommand("zrem", -3, "w", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    zremrangebyscoreCommand("zremrangebyscore", 4, "w", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    zremrangebyrankCommand("zremrangebyrank", 4, "w", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    zremrangebylexCommand("zremrangebylex", 4, "w", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    zunionstoreCommand("zunionstore", -4, "wm", zunionInterGetKeys, 0, 0, 0) {
        void proc(RedisClient redisClient) {
        }
    },
    zinterstoreCommand("zinterstore", -4, "wm", zunionInterGetKeys, 0, 0, 0) {
        void proc(RedisClient redisClient) {
        }
    },
    zrangeCommand("zrange", -4, "r", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    zrangebyscoreCommand("zrangebyscore", -4, "r", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    zrevrangebyscoreCommand("zrevrangebyscore", -4, "r", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    zrangebylexCommand("zrangebylex", -4, "r", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    zrevrangebylexCommand("zrevrangebylex", -4, "r", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    zcountCommand("zcount", 4, "r", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    zlexcountCommand("zlexcount", 4, "r", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    zrevrangeCommand("zrevrange", -4, "r", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    zcardCommand("zcard", 2, "r", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    zscoreCommand("zscore", 3, "r", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    zrankCommand("zrank", 3, "r", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    zrevrankCommand("zrevrank", 3, "r", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    zscanCommand("zscan", -3, "rR", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    hsetCommand("hset", 4, "wm", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    hsetnxCommand("hsetnx", 4, "wm", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    hgetCommand("hget", 3, "r", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    hmsetCommand("hmset", -4, "wm", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    hmgetCommand("hmget", -3, "r", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    hincrbyCommand("hincrby", 4, "wm", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    hincrbyfloatCommand("hincrbyfloat", 4, "wm", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    hdelCommand("hdel", -3, "w", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    hlenCommand("hlen", 2, "r", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    hkeysCommand("hkeys", 2, "rS", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    hvalsCommand("hvals", 2, "rS", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    hgetallCommand("hgetall", 2, "r", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    hexistsCommand("hexists", 3, "r", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    hscanCommand("hscan", -3, "rR", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    incrbyCommand("incrby", 3, "wm", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    decrbyCommand("decrby", 3, "wm", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    incrbyfloatCommand("incrbyfloat", 3, "wm", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    getsetCommand("getset", 3, "wm", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    msetCommand("mset", -3, "wm", null, 1, -1, 2) {
        void proc(RedisClient redisClient) {
        }
    },
    msetnxCommand("msetnx", -3, "wm", null, 1, -1, 2) {
        void proc(RedisClient redisClient) {
        }
    },
    randomkeyCommand("randomkey", 1, "rR", null, 0, 0, 0) {
        void proc(RedisClient redisClient) {
        }
    },
    selectCommand("select", 2, "rl", null, 0, 0, 0) {
        void proc(RedisClient redisClient) {
        }
    },
    moveCommand("move", 3, "w", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    renameCommand("rename", 3, "w", null, 1, 2, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    renamenxCommand("renamenx", 3, "w", null, 1, 2, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    expireCommand("expire", 3, "w", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    expireatCommand("expireat", 3, "w", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    pexpireCommand("pexpire", 3, "w", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    pexpireatCommand("pexpireat", 3, "w", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    keysCommand("keys", 2, "rS", null, 0, 0, 0) {
        void proc(RedisClient redisClient) {
        }
    },
    scanCommand("scan", -2, "rR", null, 0, 0, 0) {
        void proc(RedisClient redisClient) {
        }
    },
    dbsizeCommand("dbsize", 1, "r", null, 0, 0, 0) {
        void proc(RedisClient redisClient) {
        }
    },
    authCommand("auth", 2, "rslt", null, 0, 0, 0) {
        void proc(RedisClient redisClient) {
        }
    },
    pingCommand("ping", 1, "rt", null, 0, 0, 0) {
        void proc(RedisClient redisClient) {
        }
    },
    echoCommand("echo", 2, "r", null, 0, 0, 0) {
        void proc(RedisClient redisClient) {
        }
    },
    saveCommand("save", 1, "ars", null, 0, 0, 0) {
        void proc(RedisClient redisClient) {
        }
    },
    bgsaveCommand("bgsave", 1, "ar", null, 0, 0, 0) {
        void proc(RedisClient redisClient) {
        }
    },
    bgrewriteaofCommand("bgrewriteaof", 1, "ar", null, 0, 0, 0) {
        void proc(RedisClient redisClient) {
        }
    },
    shutdownCommand("shutdown", -1, "arlt", null, 0, 0, 0) {
        void proc(RedisClient redisClient) {
        }
    },
    lastsaveCommand("lastsave", 1, "rR", null, 0, 0, 0) {
        void proc(RedisClient redisClient) {
        }
    },
    typeCommand("type", 2, "r", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    multiCommand("multi", 1, "rs", null, 0, 0, 0) {
        void proc(RedisClient redisClient) {
        }
    },
    execCommand("exec", 1, "sM", null, 0, 0, 0) {
        void proc(RedisClient redisClient) {
        }
    },
    discardCommand("discard", 1, "rs", null, 0, 0, 0) {
        void proc(RedisClient redisClient) {
        }
    },
    syncCommand("sync", 1, "ars", null, 0, 0, 0) {
        void proc(RedisClient redisClient) {
        }
    },
    syncCommand2("psync", 3, "ars", null, 0, 0, 0) {
        void proc(RedisClient redisClient) {
        }
    },
    replconfCommand("replconf", -1, "arslt", null, 0, 0, 0) {
        void proc(RedisClient redisClient) {
        }
    },
    flushdbCommand("flushdb", 1, "w", null, 0, 0, 0) {
        void proc(RedisClient redisClient) {
        }
    },
    flushallCommand("flushall", 1, "w", null, 0, 0, 0) {
        void proc(RedisClient redisClient) {
        }
    },
    sortCommand("sort", -2, "wm", sortGetKeys, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    infoCommand("info", -1, "rlt", null, 0, 0, 0) {
        void proc(RedisClient redisClient) {
        }
    },
    monitorCommand("monitor", 1, "ars", null, 0, 0, 0) {
        void proc(RedisClient redisClient) {
        }
    },
    ttlCommand("ttl", 2, "r", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    pttlCommand("pttl", 2, "r", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    persistCommand("persist", 2, "w", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    slaveofCommand("slaveof", 3, "ast", null, 0, 0, 0) {
        void proc(RedisClient redisClient) {
        }
    },
    debugCommand("debug", -2, "as", null, 0, 0, 0) {
        void proc(RedisClient redisClient) {
        }
    },
    configCommand("config", -2, "art", null, 0, 0, 0) {
        void proc(RedisClient redisClient) {
        }
    },
    subscribeCommand("subscribe", -2, "rpslt", null, 0, 0, 0) {
        void proc(RedisClient redisClient) {
        }
    },
    unsubscribeCommand("unsubscribe", -1, "rpslt", null, 0, 0, 0) {
        void proc(RedisClient redisClient) {
        }
    },
    psubscribeCommand("psubscribe", -2, "rpslt", null, 0, 0, 0) {
        void proc(RedisClient redisClient) {
        }
    },
    punsubscribeCommand("punsubscribe", -1, "rpslt", null, 0, 0, 0) {
        void proc(RedisClient redisClient) {
        }
    },
    publishCommand("publish", 3, "pltr", null, 0, 0, 0) {
        void proc(RedisClient redisClient) {
        }
    },
    pubsubCommand("pubsub", -2, "pltrR", null, 0, 0, 0) {
        void proc(RedisClient redisClient) {
        }
    },
    watchCommand("watch", -2, "rs", null, 1, -1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    unwatchCommand("unwatch", 1, "rs", null, 0, 0, 0) {
        void proc(RedisClient redisClient) {
        }
    },
    clusterCommand("cluster", -2, "ar", null, 0, 0, 0) {
        void proc(RedisClient redisClient) {
        }
    },
    restoreCommand("restore", -4, "awm", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    restoreCommand2("restore-asking", -4, "awmk", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    migrateCommand("migrate", -6, "aw", null, 0, 0, 0) {
        void proc(RedisClient redisClient) {
        }
    },
    askingCommand("asking", 1, "r", null, 0, 0, 0) {
        void proc(RedisClient redisClient) {
        }
    },
    readonlyCommand("readonly", 1, "r", null, 0, 0, 0) {
        void proc(RedisClient redisClient) {
        }
    },
    readwriteCommand("readwrite", 1, "r", null, 0, 0, 0) {
        void proc(RedisClient redisClient) {
        }
    },
    dumpCommand("dump", 2, "ar", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    objectCommand("object", -2, "r", null, 2, 2, 2) {
        void proc(RedisClient redisClient) {
        }
    },
    clientCommand("client", -2, "ar", null, 0, 0, 0) {
        void proc(RedisClient redisClient) {
        }
    },
    evalCommand("eval", -3, "s", evalGetKeys, 0, 0, 0) {
        void proc(RedisClient redisClient) {
        }
    },
    evalShaCommand("evalsha", -3, "s", evalGetKeys, 0, 0, 0) {
        void proc(RedisClient redisClient) {
        }
    },
    slowlogCommand("slowlog", -2, "r", null, 0, 0, 0) {
        void proc(RedisClient redisClient) {
        }
    },
    scriptCommand("script", -2, "ras", null, 0, 0, 0) {
        void proc(RedisClient redisClient) {
        }
    },
    timeCommand("time", 1, "rR", null, 0, 0, 0) {
        void proc(RedisClient redisClient) {
        }
    },
    bitopCommand("bitop", -4, "wm", null, 2, -1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    bitcountCommand("bitcount", -2, "r", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    bitposCommand("bitpos", -3, "r", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    waitCommand("wait", 3, "rs", null, 0, 0, 0) {
        void proc(RedisClient redisClient) {
        }
    },
    pfselftestCommand("pfselftest", 1, "r", null, 0, 0, 0) {
        void proc(RedisClient redisClient) {
        }
    },
    pfaddCommand("pfadd", -2, "wm", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    pfcountCommand("pfcount", -2, "w", null, 1, 1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    pfmergeCommand("pfmerge", -2, "wm", null, 1, -1, 1) {
        void proc(RedisClient redisClient) {
        }
    },
    pfdebugCommand("pfdebug", -3, "w", null, 0, 0, 0) {
        void proc(RedisClient redisClient) {
        }
    },


    ;

    public final String name;
    /**
     * number of arguments, it is possible to use -N to say >= N
     * 参数的数量。可以用 -N 表示 >= N
     */
    public int arity;

    // 字符串表示的 FLAG
    public String sflags; /* flags as bitmask Flags as string representation, one char per flag. */

    // 实际 FLAG
    public int flags;    /* The actual flags, obtained from the 'sflags' field. */

    /* Use a function to determine keys arguments in a command line.
     * Used for Redis Cluster redirect. */
    // 从命令中判断命令的键参数。在 Redis 集群转向时使用。
    RedisGetKeysProc getkeys_proc;

    /* What keys should be loaded in background when calling this command? */
    // 指定哪些参数是 key
    public int firstkey; /* The first argument that's a key (0 = no keys) */
    public int lastkey;  /* The last argument that's a key */
    public int keystep;  /* The step between first and last key */


    RedisCommandProc(String name) {
        this.name = name;
    }

    RedisCommandProc(String name, int arity, String sflags, RedisGetKeysProc getkeys_proc, int firstkey, int lastkey, int keystep) {
        this.name = name;
        this.arity = arity;
        this.sflags = sflags;
        this.getkeys_proc = getkeys_proc;
        this.firstkey = firstkey;
        this.lastkey = lastkey;
        this.keystep = keystep;
    }

    abstract void proc(RedisClient redisClient);



    public RedisCommand getRedisCommandVo(){
        RedisCommand command = new RedisCommand(name,this,arity,sflags,getkeys_proc,firstkey,lastkey,keystep);
        return command;
    }
}
