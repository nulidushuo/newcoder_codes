package com.class5;

import java.util.HashMap;

public class RandomPool {

    public static class Pool<K> {
        private HashMap<K, Integer> keyIndexMap;
        private HashMap<Integer, K> indexKeyMap;
        private int size;

        public Pool(){
            keyIndexMap = new HashMap<>();
            indexKeyMap = new HashMap<>();
            size = 0;
        }

        public void insert(K key){
            if(!keyIndexMap.containsKey(key)){
                keyIndexMap.put(key, size);
                indexKeyMap.put(size, key);
                size++;
            }
        }

        public K getRandom(){
            if(this.size == 0){
                return null;
            }

            int rand = (int) (Math.random() * size);
            return this.indexKeyMap.get(rand);
        }

        public void delete(K key){
            if(keyIndexMap.containsKey(key)){
                int deleteIndex = keyIndexMap.get(key);
                int lastIndex = size - 1;
                K lastKey = indexKeyMap.get(lastIndex);
                keyIndexMap.put(lastKey, deleteIndex);
                indexKeyMap.put(deleteIndex, lastKey);
                keyIndexMap.remove(key);
                indexKeyMap.remove(lastIndex);
                size++;
            }
        }
    }

    public static void main(String[] args) {
        Pool<String> pool = new Pool<>();

        pool.insert("zuo");
        pool.insert("cheng");
        pool.insert("yun");
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());

    }

}
