package com.study.redis.dict.h;

import lombok.Data;

import static com.study.redis.dict.h.DictH.DICT_OK;

/**
 * @author chenxuegui
 * @since 2021.07.27
 * 字典
 */
@Data
public class Dict<K,V> {
    // 类型特定函数
    public DictType type;

    // 私有数据
    public Object privdata;

    // 哈希表
    public DictHashTable<K,V>[] ht = new DictHashTable[2];

    // rehash 索引
    // 当 rehash 不在进行时，值为 -1
    public int rehashidx; /* rehashing not in progress if rehashidx == -1 */

    // 目前正在运行的安全迭代器的数量
    public int iterators; /* number of iterators currently running */


    public int dictAdd(K key,V val){
        if(dictIsRehashing()){
            dictRehashStep();
        }
        DictHashTable<K,V> table = dictIsRehashing() ? ht[1] : ht[0];

        table.put(key, val);
        table.used++;

        return DICT_OK;
    }

    public V  dictFetchValue(K key){
        if(ht[0].isEmpty()){
            return null;
        }
        // 如果条件允许的话，进行单步 rehash
        if (dictIsRehashing()) dictRehashStep();
        for (int table = 0; table <= 1; table++) {
            V val = ht[table].get(key);
            if(val !=null){
                return val;
            }
        }
        return null;
    }



    private boolean dictIsRehashing(){
        return rehashidx != -1;
    }

    /* This function performs just a step of rehashing, and only if there are
     * no safe iterators bound to our hash table. When we have iterators in the
     * middle of a rehashing we can't mess with the two hash tables otherwise
     * some element can be missed or duplicated.
     *
     * 在字典不存在安全迭代器的情况下，对字典进行单步 rehash 。
     *
     * 字典有安全迭代器的情况下不能进行 rehash ，
     * 因为两种不同的迭代和修改操作可能会弄乱字典。
     *
     * This function is called by common lookup or update operations in the
     * dictionary so that the hash table automatically migrates from H1 to H2
     * while it is actively used.
     *
     * 这个函数被多个通用的查找、更新操作调用，
     * 它可以让字典在被使用的同时进行 rehash 。
     *
     * T = O(1)
     */
     private void dictRehashStep() {
        if (iterators == 0) dictRehash(1);
    }
    /* Performs N steps of incremental rehashing. Returns 1 if there are still
     * keys to move from the old to the new hash table, otherwise 0 is returned.
     *
     * 执行 N 步渐进式 rehash 。
     *
     * 返回 1 表示仍有键需要从 0 号哈希表移动到 1 号哈希表，
     * 返回 0 则表示所有键都已经迁移完毕。
     *
     * Note that a rehashing step consists in moving a bucket (that may have more
     * than one key as we use chaining) from the old to the new hash table.
     *
     * 注意，每步 rehash 都是以一个哈希表索引（桶）作为单位的，
     * 一个桶里可能会有多个节点，
     * 被 rehash 的桶里的所有节点都会被移动到新哈希表。
     *
     * T = O(N)
     */
    private int dictRehash(int n) {
        return 0;
    }

}
