package com.study.redis.dict.h;

import com.study.redis.redis.h.RedisCommand;

/**
 * @author chenxuegui
 * @since 2021.07.29
 * This file implements in-memory hash tables with insert/del/replace/find/
 * get-random-element operations. Hash tables will auto-resize if needed
 * tables of power of two in size are used, collisions are handled by
 * chaining. See the source code for more information... :)
 *
 * 这个文件实现了一个内存哈希表，
 * 它支持插入、删除、替换、查找和获取随机元素等操作。
 * 哈希表会自动在表的大小的二次方之间进行调整。h[1].size = h[0].size *2
 * 键的冲突通过链表来解决。
 */
public class DictH {
    public final static int DICT_OK = 0;
    public final static int DICT_ERR = 0;

    /* Create a new hash table
     * 创建一个新的字典
     */
    public static Dict<String, RedisCommand> dictCreate(DictType type,Object privDataPtr) {
        Dict<String, RedisCommand> d = new Dict();

        _dictInit(d,type,privDataPtr);

        return d;
    }

    /* Initialize the hash table
     * 初始化哈希表
     */
    public static int _dictInit(Dict d, DictType type, Object privDataPtr) {
        // 初始化两个哈希表的各项属性值
        // 但暂时还不分配内存给哈希表数组
        //_dictReset(&d->ht[0]);
        //_dictReset(&d->ht[1]);

        // 设置类型特定函数
        d.type = type;

        // 设置私有数据
        d.privdata = privDataPtr;

        // 设置哈希表 rehash 状态
        d.rehashidx = -1;

        // 设置字典的安全迭代器数量
        d.iterators = 0;

        return DICT_OK;
    }
}
