package com.study.redis.redis.h;

/**
 * @author chenxuegui
 * @since 2021.10.20
 */
public class SDS extends SDShdr {


    private StringBuilder buf = new StringBuilder();


    public static SDS sdsnew(String init){
        SDS sds = new SDS();
        sds.buf.append(init);
        return sds;
    }
}
