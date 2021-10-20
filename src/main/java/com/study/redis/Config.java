package com.study.redis;

import com.study.redis.redis.h.AOF_FSYNC;
import com.study.redis.redis.h.MaxmemoryPolicy;
import com.study.redis.redis.h.RedisServer;
import com.study.redis.redis.h.SaveParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import static com.study.redis.redis.h.ServerConf.REDIS_MAX_HZ;
import static com.study.redis.redis.h.ServerConf.REDIS_MIN_HZ;

/**
 * @author chenxuegui
 * @since 2021.08.12
 */
@Slf4j
public class Config {

    public static void loadServerConfig(RedisServer server){
        loadServerConfigFromString(server);
    }

    public static void loadServerConfigFromString(RedisServer server){

        try {

            String filePath = Config.class.getClassLoader().getResource("redis.conf").getPath();
            File file = new File(filePath);
            InputStreamReader read = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
            BufferedReader bufferReader = new BufferedReader(read);
            String lineTXT;
            while ((lineTXT = bufferReader.readLine()) != null) {

                lineTXT = lineTXT.replace("\t","").replace("\n","").replace("\n","");
                lineTXT = lineTXT.trim();
                // 跳过空白行
                if(lineTXT.startsWith("#") || StringUtils.isBlank(lineTXT)){
                    continue;
                }
                // 将字符串分割成多个参数
                log.info("loadServerConfigFromString config={}",lineTXT);
                String[] argv = lineTXT.split(" ");
                log.info("loadServerConfigFromString argv={}",argv);

                String op = argv[0];
                //客户端空闲超时时间
                if("timeout".equals(op)){
                    server.maxidletime = Integer.parseInt(argv[1]);
                    if(server.maxidletime <0){
                        invalidConfigValue(server.maxidletime);
                    }
                }

                //客户端存活探测
                if("tcp-keepalive".equals(op)){
                    server.tcpkeepalive = Integer.parseInt(argv[1]);
                    if(server.tcpkeepalive <0){
                        invalidConfigValue(server.tcpkeepalive);
                    }
                }

                if("port".equals(op)){
                    server.port = Integer.parseInt(argv[1]);
                    if(server.port<0 || server.port>65535){
                        invalidConfigValue(server.port);
                    }
                }

                //链接缓冲队列
                if("tcp-backlog".equals(op)){
                    server.tcp_backlog = Integer.parseInt(argv[1]);
                    if(server.tcp_backlog<0){
                        invalidConfigValue("tcp_backlog");
                    }
                }

                //数据库快照
                /*一般来说，在生产环境很少执行 SAVE 操作，因为它会阻塞所有客户端，保存数据库的任务通常由 BGSAVE 命令异步地执行*/
                if("save".equals(op)){
                    if(argv.length==3){
                        int seconds = Integer.parseInt(argv[1]);
                        int changes = Integer.parseInt(argv[2]);
                        if (seconds < 1 || changes < 0) {
                            invalidConfigValue("save parameters");
                        }
                        appendServerSaveParams(server,seconds,changes);
                    }else if(argv.length==2 && "".equals(argv[1])){
                        resetServerSaveParams(server);
                    }
                }

                //同时在线最大客户端数
                if("maxclients".equals(op)){
                    server.maxclients = Integer.parseInt(argv[1]);
                    if(server.maxclients <1){
                        invalidConfigValue("maxclients="+server.maxclients);
                    }
                }

                //最大内存
                if("maxmemory".equals(op)){
                    server.maxmemory =  Long.parseLong(argv[1]);
                }

                //内存淘汰策略
                if("maxmemory-policy".equals(op)){
                    server.maxmemory_policy = MaxmemoryPolicy.getPolicy(argv[1]).id;
                }

                if("maxmemory-samples".equals(op)){
                    server.maxmemory_samples = Integer.parseInt(argv[1]);
                    if (server.maxmemory_samples <= 0) {
                        invalidConfigValue("maxmemory-samples must be 1 or greater");
                    }
                }

                //slaveof 备份节点相关


                if("activerehashing".equals(op)){
                    server.activerehashing = yesNoToInt(argv[1]);
                    if(server.activerehashing == -1){
                        invalidConfigValue("activerehashing must be 'yes' or 'no'");
                    }
                }

                if("daemonize".equals(op)){
                    server.daemonize = yesNoToBool(argv[1]);
                }

                //定时器频率
                if("hz".equals(op)){
                    server.hz = Integer.parseInt(argv[1]);
                    if (server.hz < REDIS_MIN_HZ) server.hz = REDIS_MIN_HZ;
                    if (server.hz > REDIS_MAX_HZ) server.hz = REDIS_MAX_HZ;
                }

                //写命令追加日志
                if("appendonly".equals(op)){
                    server.aof_state = yesNoToInt(argv[1]);
                    if(server.aof_state == -1){
                        invalidConfigValue("appendonly must be 'yes' or 'no'");
                    }
                }

                //aof刷盘频率
                if("appendfsync".equals(op)){
                    server.aof_fsync = AOF_FSYNC.getAOFFSYNC(argv[1]).id;
                }

                //节省空间的紧凑格式
                if("hash-max-ziplist-entries".equals(op)){
                    server.hash_max_ziplist_entries = Integer.parseInt(argv[1]);
                }
                if("hash-max-ziplist-value".equals(op)){
                    server.hash_max_ziplist_value = Integer.parseInt(argv[1]);
                }

                if("list-max-ziplist-entries".equals(op)){
                    server.list_max_ziplist_entries = Integer.parseInt(argv[1]);
                }
                if("list-max-ziplist-value".equals(op)){
                    server.list_max_ziplist_value = Integer.parseInt(argv[1]);
                }

                if("set-max-intset-entries".equals(op)){
                    server.set_max_intset_entries = Integer.parseInt(argv[1]);
                }
                if("zset-max-ziplist-entries".equals(op)){
                    server.zset_max_ziplist_entries = Integer.parseInt(argv[1]);
                }
                if("zset-max-ziplist-value".equals(op)){
                    server.zset_max_ziplist_value = Integer.parseInt(argv[1]);
                }

                //集群配置





            }
        }catch (Exception e){
            log.error("loadServerConfigFromString error",e);
        }


    }

    private static void invalidConfigValue(Object value){
        throw new RuntimeException("Invalid config value "+value);
    }

    private  static int yesNoToInt(String val){
        if("yes".equals(val)){
            return 1;
        }else if("no".equals(val)){
            return 0;
        }
        return -1;
    }

    private  static boolean yesNoToBool(String val){
        boolean b = false;
        if(yesNoToInt(val) == 1){
            b = true;
        }
        return b;
    }



    public static void appendServerSaveParams(RedisServer server,int seconds, int changes) {
        server.saveparams.add(new SaveParam(seconds,changes));
        server.saveparamslen = server.saveparams.size();
    }

    public static void resetServerSaveParams(RedisServer server) {
        server.saveparams = new ArrayList<>();
        server.saveparamslen = server.saveparams.size();
    }

    public static void main(String[] args) {
        loadServerConfigFromString(new RedisServer());
    }
}
