package com.study.redis.redis.command;

import static com.study.redis.redis.h.ServerConf.*;

/**
 * @author chenxuegui
 * @since 2021.07.30
 * 命令的 FLAG 首先由 SFLAG 域设置，之后 populateCommandTable() 函数从 sflags 属性中计算出真正的 FLAG 到 flags 属性中。
 */
public enum CommandFlag {

    w(REDIS_CMD_WRITE,"write command (may modify the key space)"),
    r(REDIS_CMD_READONLY, "read command  (will never modify the key space)"),
    m(REDIS_CMD_DENYOOM, "may increase memory usage once called. Don't allow if out of memory."),
    a(REDIS_CMD_ADMIN, "admin command, like SAVE or SHUTDOWN."),
    p(REDIS_CMD_PUBSUB, "Pub/Sub related command."),
    f("force replication of this command, regardless of server.dirty."),
    s(REDIS_CMD_NOSCRIPT,"command not allowed in scripts."),
    R(REDIS_CMD_RANDOM,"random command. Command is not deterministic, that is, the same command\n" +
            " *    with the same arguments, with the same key space, may have different\n" +
            " *    results. For instance SPOP and RANDOMKEY are two random commands."),
    S(REDIS_CMD_SORT_FOR_SCRIPT,"Sort command output array if called from script, so that the output\n" +
            " *    is deterministic"),
    l(REDIS_CMD_LOADING,"Allow command while loading the database."),
    t(REDIS_CMD_STALE,"Allow command while a slave has stale data but is not allowed to\n" +
            " *    server this data. Normally no command is accepted in this condition\n" +
            " *    but just a few."),
    M(REDIS_CMD_SKIP_MONITOR,"Do not automatically propagate the command on MONITOR."),
    k(REDIS_CMD_ASKING,"Perform an implicit ASKING for this command, so the command will be\n" +
            " *    accepted in cluster mode if the slot is marked as 'importing'.\n" +
            " *    为这个命令执行一个显式的 ASKING"),

    ;

    public String desc;
    public int flag;
    CommandFlag(String desc) {
        this.desc = desc;
    }

    CommandFlag(int flag, String desc) {
        this.desc = desc;
        this.flag = flag;
    }
    public static CommandFlag getCommandFlag(char sflag){
        for (CommandFlag value : values()) {
            if(value.name().equals(sflag+"")){
                return value;
            }
        }
        throw new RuntimeException(sflag +" CommandFlag not found");
    }
}
