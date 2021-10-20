package com.study.redis.redis.h;

/**
 * @author chenxuegui
 * @since 2021.10.19
 */
public enum AOF_FSYNC {
    AOF_FSYNC_NO(0,"no"),
    AOF_FSYNC_ALWAYS(1,"always"),
    AOF_FSYNC_EVERYSEC(2,"everysec"),

    ;

    public int id;
    public String name;

    AOF_FSYNC(int id) {
        this.id = id;
    }

    AOF_FSYNC(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static AOF_FSYNC getAOFFSYNC(String name){
        for (AOF_FSYNC e : values()) {
            if(e.name.equals(name)){
                return e;
            }
        }
        throw new RuntimeException("getAOFFSYNC not found for name="+name);
    }
}
