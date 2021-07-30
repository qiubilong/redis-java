package com.study.redis.dict.h;

/**
 * @author chenxuegui
 * @since 2021.07.27
 * 字典类型特定函数
 */
public enum DictType {
    /* Command table. sds string */
    commandTableDictType  {
        @Override
        int hashFunction(Object key) {
            return 0;
        }

        @Override
        Object keyDup(Object privdata, Object key) {
            return null;
        }

        @Override
        Object valDup(Object privdata, Object obj) {
            return null;
        }

        @Override
        int keyCompare(Object privdata, Object key1, Object key2) {
            return 0;
        }

        @Override
        void keyDestructor(Object privdata, Object key) {

        }

        @Override
        void valDestructor(Object privdata, Object obj) {

        }
    },
    ;

    // 计算哈希值的函数
    abstract  int hashFunction (Object key);

    // 复制键的函数
    abstract  Object keyDup(Object privdata, Object key);

    // 复制值的函数
    abstract  Object valDup(Object privdata, Object obj);

    // 对比键的函数
    abstract int keyCompare(Object privdata,Object key1,Object key2);

    // 销毁键的函数
    abstract void keyDestructor(Object privdata, Object key);

    // 销毁值的函数
    abstract void valDestructor(Object privdata, Object obj);

}
