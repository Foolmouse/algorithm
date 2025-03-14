package main.java.net.coding;

/**
 * 一个简单的 Pair 工具类，用于存储两个值。
 *
 * @param <K> 第一个值的类型
 * @param <V> 第二个值的类型
 */
public class Pair<K, V> {
    private final K key;
    private final V value;

    /**
     * 构造函数，初始化 Pair。
     *
     * @param key   第一个值
     * @param value 第二个值
     */
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    /**
     * 获取第一个值。
     *
     * @return 第一个值
     */
    public K getKey() {
        return key;
    }

    /**
     * 获取第二个值。
     *
     * @return 第二个值
     */
    public V getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}