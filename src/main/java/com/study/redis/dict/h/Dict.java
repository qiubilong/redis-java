package com.study.redis.dict.h;

import lombok.Data;

/**
 * @author chenxuegui
 * @since 2021.07.27
 * 字典
 */
@Data
public class Dict {
    // 类型特定函数
    public DictType type;

    // 私有数据
    public Object privdata;

    // 哈希表
    public DictHashTable[] ht = new DictHashTable[2];

    // rehash 索引
    // 当 rehash 不在进行时，值为 -1
    public int rehashidx; /* rehashing not in progress if rehashidx == -1 */

    // 目前正在运行的安全迭代器的数量
    public int iterators; /* number of iterators currently running */

}
