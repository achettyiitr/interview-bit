package heapsandmaps;

import java.util.LinkedHashMap;

public class LRUCache {
    public class Solution {
        private LinkedHashMap<Integer, Integer> cache;
        private int capacity;

        public Solution(int capacity) {
            this.cache = new LinkedHashMap<>(capacity);
            this.capacity = capacity;
        }

        public int get(int key) {
            if (cache.containsKey(key)) {
                Integer value = cache.get(key);
                cache.remove(key);
                cache.put(key, value);
                return value;
            } else {
                return -1;
            }
        }

        public void set(int key, int value) {
            if (cache.containsKey(key)) {
                cache.remove(key);
            } else {
                if (cache.size() == capacity) {
                    Integer dKey = cache.keySet().iterator().next();
                    cache.remove(dKey);
                }
            }
            cache.put(key, value);
        }
    }
}
