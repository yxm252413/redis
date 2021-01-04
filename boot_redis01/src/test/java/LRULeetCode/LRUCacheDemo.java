package LRULeetCode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Classname LRUCacheDemo
 * @Description 依赖JDK, 参考LinkedHashMap
 * @Date 2021/1/4
 * @Created by yxm
 */
public class LRUCacheDemo<K, V> extends LinkedHashMap<K, V> {

    private int capacity;//缓存坑位

    public LRUCacheDemo(int capacity) {
        super(capacity, 0.75F, false);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return super.size() > capacity;
    }

    public static void main(String[] args) {
        LRUCacheDemo lruCacheDemo = new LRUCacheDemo(3);

        lruCacheDemo.put(1, "a");
        lruCacheDemo.put(2, "b");
        lruCacheDemo.put(3, "c");
        System.out.println(lruCacheDemo.keySet());

        lruCacheDemo.put(4, "d");
        System.out.println(lruCacheDemo.keySet());

        lruCacheDemo.put(3, "c");
        System.out.println(lruCacheDemo.keySet());
        lruCacheDemo.put(3, "c");
        System.out.println(lruCacheDemo.keySet());
        lruCacheDemo.put(3, "c");
        System.out.println(lruCacheDemo.keySet());
        lruCacheDemo.put(5, "x");
        System.out.println(lruCacheDemo.keySet());
    }
}


/**
 * super(capacity, 0.75F, true);
 * [1, 2, 3]
 *
 * [2, 3, 4]
 * [2, 4, 3]
 * [2, 4, 3]
 * [2, 4, 3]
 *
 * [4, 3, 5]
 * */

/**super(capacity, 0.75F, false);
 [1, 2, 3]

 [2, 3, 4]
 [2, 3, 4]
 [2, 3, 4]
 [2, 3, 4]

 [3, 4, 5]
 */