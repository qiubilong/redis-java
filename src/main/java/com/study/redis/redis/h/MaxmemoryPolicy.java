package com.study.redis.redis.h;

/**
 * @author chenxuegui
 * @since 2021.10.18
 * 内存空间耗尽时，淘汰内存策略
 */
public enum MaxmemoryPolicy {

    /***
     *  public static int REDIS_MAXMEMORY_VOLATILE_LRU = 0;
     *     public static int REDIS_MAXMEMORY_VOLATILE_TTL = 1;
     *     public static int REDIS_MAXMEMORY_VOLATILE_RANDOM = 2;
     *     public static int REDIS_MAXMEMORY_ALLKEYS_LRU = 3;
     *     public static int REDIS_MAXMEMORY_ALLKEYS_RANDOM = 4;
     *     public static int REDIS_MAXMEMORY_NO_EVICTION = 5;
     */

    REDIS_MAXMEMORY_VOLATILE_LRU(0,"volatile-lru","设置过期时间，最近最少使用的数据"),
    REDIS_MAXMEMORY_VOLATILE_TTL(1,"volatile-ttl","设置过期时间，即将过期的数据"),
    REDIS_MAXMEMORY_VOLATILE_RANDOM(2, "volatile-random","设置过期时间，随机淘汰数据"),

    REDIS_MAXMEMORY_ALLKEYS_LRU(3,"allkeys-lru","所有数据集，最近最少使用的数据"),
    REDIS_MAXMEMORY_ALLKEYS_RANDOM(4,"allkeys-random","所有数据集，随机淘汰数据"),

    REDIS_MAXMEMORY_NO_EVICTION(5,"noeviction","内存满时不做检查，返回错误码，默认策略"),

            ;

    MaxmemoryPolicy(String name) {
        this.name = name;
    }

    MaxmemoryPolicy(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    MaxmemoryPolicy(int id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
    }

    public int id;
    public String name;
    public String desc;

    public static MaxmemoryPolicy getPolicy(String name){
        for (MaxmemoryPolicy policy : values()) {
            if(policy.name.equals(name)){
                return policy;
            }
        }
        throw new RuntimeException("getPolicy not found for name="+name);
    }
}
