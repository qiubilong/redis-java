package com.study.redis.dict.h;

import lombok.Data;

/**
 * @author chenxuegui
 * @since 2021.07.28
 * This is our hash table structure. Every dictionary has two of this as we
 * implement incremental rehashing, for the old to the new table.
 *
 * 每个字典都使用两个哈希表，从而实现渐进式 rehash 。
 */
@Data
public class DictHashTable {
    // 哈希表数组
    DictEntry[] table;

    // 哈希表大小
    public long size;

    // 哈希表大小掩码，用于计算索引值
    // 总是等于 size - 1
    public long sizemask;

    // 该哈希表已有节点的数量
    public  long used;
}
