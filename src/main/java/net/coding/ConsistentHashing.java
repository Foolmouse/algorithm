package main.java.net.coding;

import java.util.*;

/**
 * 哈希一致性工具类
 */
public class ConsistentHashing<T> {
    // 虚拟节点数，用于平衡负载
    private final int numberOfReplicas;
    // 哈希环，使用 TreeMap 实现
    private final TreeMap<Integer, T> circle = new TreeMap<>();

    /**
     * 构造函数
     *
     * @param numberOfReplicas 每个节点的虚拟节点数
     * @param nodes           初始节点列表
     */
    public ConsistentHashing(int numberOfReplicas, Collection<T> nodes) {
        this.numberOfReplicas = numberOfReplicas;
        for (T node : nodes) {
            add(node);
        }
    }

    /**
     * 添加节点
     *
     * @param node 节点
     */
    public void add(T node) {
        for (int i = 0; i < numberOfReplicas; i++) {
            // 为每个虚拟节点生成哈希值，并添加到哈希环中
            int hash = getHash(node.toString() + "-" + i); // 增加唯一标识
            circle.put(hash, node);
        }
    }

    /**
     * 移除节点
     *
     * @param node 节点
     */
    public void remove(T node) {
        for (int i = 0; i < numberOfReplicas; i++) {
            // 移除所有虚拟节点
            int hash = getHash(node.toString() + "-" + i);
            circle.remove(hash);
        }
    }

    /**
     * 根据 key 获取对应的节点
     *
     * @param key 键
     * @return 节点
     */
    public T get(Object key) {
        if (circle.isEmpty()) {
            return null;
        }
        // 计算 key 的哈希值
        int hash = getHash(key.toString());
        // 在哈希环中查找最近的节点
        if (!circle.containsKey(hash)) {
            SortedMap<Integer, T> tailMap = circle.tailMap(hash);
            hash = tailMap.isEmpty() ? circle.firstKey() : tailMap.firstKey();
        }
        return circle.get(hash);
    }

    /**
     * 计算哈希值（使用更复杂的哈希函数）
     *
     * @param key 键
     * @return 哈希值
     */
    private int getHash(String key) {
        // 使用 MD5 哈希算法
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(key.getBytes());
            return Math.abs(new java.math.BigInteger(1, digest).intValue());
        } catch (java.security.NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 algorithm not found", e);
        }
    }

    /**
     * 获取哈希环中的所有节点
     *
     * @return 节点列表
     */
    public Collection<T> getNodes() {
        return new HashSet<>(circle.values());
    }

    public static void main(String[] args) {
        // 初始化节点
        List<String> nodes = Arrays.asList("Node-A", "Node-B", "Node-C");
        ConsistentHashing<String> consistentHashing = new ConsistentHashing<>(3, nodes);

        // 测试 key 的分布
        String[] keys = {"Key-1", "Key-2", "Key-3", "Key-4", "Key-5"};
        for (String key : keys) {
            String node = consistentHashing.get(key);
            System.out.println("Key: " + key + " -> Node: " + node);
        }

        // 添加新节点
        System.out.println("\nAdding new node: Node-D");
        consistentHashing.add("Node-D");
        for (String key : keys) {
            String node = consistentHashing.get(key);
            System.out.println("Key: " + key + " -> Node: " + node);
        }

        // 移除节点
        System.out.println("\nRemoving node: Node-B");
        consistentHashing.remove("Node-B");
        for (String key : keys) {
            String node = consistentHashing.get(key);
            System.out.println("Key: " + key + " -> Node: " + node);
        }
    }


}