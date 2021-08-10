package com.study.redis.redis.h;

import com.study.redis.redis.command.CommandFlag;
import com.study.redis.redis.command.RedisCommandProc;
import com.study.redis.redis.command.RedisGetKeysProc;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/** redis 命令 */
@Data
public  class RedisCommand {


    // 命令名字
    public String name;

    // 实现函数
    RedisCommandProc proc;

    /** number of arguments, it is possible to use -N to say >= N
     *        参数的数量。可以用 -N 表示 >= N */
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

    // 统计信息
    // microseconds 记录了命令执行耗费的总毫微秒数
    // calls 是命令被执行的总次数
    public long microseconds, calls;

    public RedisCommand(String name, RedisCommandProc proc, int arity, List<CommandFlag> sflags, int flags, RedisGetKeysProc getkeys_proc, int firstkey, int lastkey, int keystep) {
        this.name = name;
        this.proc = proc;
        this.arity = arity;
        this.sflags = StringUtils.join(sflags,"");
        this.flags = flags;
        this.getkeys_proc = getkeys_proc;
        this.firstkey = firstkey;
        this.lastkey = lastkey;
        this.keystep = keystep;
    }

    public RedisCommand(String name, RedisCommandProc proc, int arity, String sflags, RedisGetKeysProc getkeys_proc, int firstkey, int lastkey, int keystep) {
        this.name = name;
        this.proc = proc;
        this.arity = arity;
        this.sflags = sflags;
        this.getkeys_proc = getkeys_proc;
        this.firstkey = firstkey;
        this.lastkey = lastkey;
        this.keystep = keystep;
    }
}