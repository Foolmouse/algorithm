package net.coding.leetCode;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
 * 实现 LRUCache 类：
 * <p>
 * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *  
 * <p>
 * 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lru-cache
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * <p>
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 * <p>
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1);    // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1);    // 返回 -1 (未找到)
 * lRUCache.get(3);    // 返回 3
 * lRUCache.get(4);    // 返回 4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lru-cache
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LRUCache2 {
    // 为什么要自己写链表?
    // 用链表维护最近活跃的关系( head不活跃->tail 最近活跃)
    // 自己写链表可以获得 pre,next,方便进行节点删除,避免循环查找节点
    class ListNode {
        public int key, value;
        public ListNode pre, next;

        ListNode() {
        }

        ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    //缓存的容量
    int cap;
    //编造一个固定的头尾节点,方便进行添加到tail和删除head
    ListNode head, tail;
    //哈希表存储 key,value 关系
    HashMap<Integer, ListNode> map;

    public LRUCache2(int capacity) {
        cap = capacity;
        head = new ListNode();
        tail = new ListNode();
        head.next = tail;
        tail.pre = head;
        map = new HashMap<>(capacity, 1);
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            //从链表中删除节点
            removeNode(node);
            //放到链表最后
            pushToLast(node);
            return map.get(key).value;
        }
        return -1;
    }

    public void put(int key, int value) {
        //如果key已存在,删掉原节点
        if (map.containsKey(key)) {
            removeNode(map.get(key));
        //如果容量满了,删掉头节点
        } else if (map.size() == cap) {
            final ListNode node = removeHeadNode();
            map.remove(node.key);
        }
        //添加节点到tail
        ListNode listNode = new ListNode(key, value);
        pushToLast(listNode);
        map.put(key, listNode);
    }

    private void removeNode(ListNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private ListNode removeHeadNode() {
        final ListNode next = head.next;
        head.next = head.next.next;
        head.next.pre = head;
        return next;
    }

    private void pushToLast(ListNode node) {
        ListNode pre = tail.pre;
        pre.next = node;
        tail.pre = node;
        node.pre = pre;
        node.next = tail;
    }


}
