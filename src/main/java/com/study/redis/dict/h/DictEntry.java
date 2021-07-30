package com.study.redis.dict.h;

import lombok.Data;

/**
 * @author chenxuegui
 * @since 2021.07.28
 * 哈希表DictHashTable节点
 */
@Data
public class DictEntry {

    // 键
    public Object key;

    // 值
    public Val v;

    // 指向下个哈希表节点，形成链表
    public DictEntry next;

    @Data
    public static class Val{
        public Object val;
        public long u64;
        public long s64;
    }
}
