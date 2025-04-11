package main.java.net.coding.linked;

import java.util.Collection;

// 定义链表类
public class NodeList<I extends Number> {

    public ListNode head;
    private int size;

    public NodeList() {
        head = null;
        size = 0;
    }

    // 根据传入的集合生成链表
    public NodeList(Collection<Integer> values) {
        this();
        for (int value : values) {
            addLast(value);
        }
    }

    // 根据传入的集合生成链表
    public NodeList(int... values) {
        this();
        for (int value : values) {
            addLast(value);
        }
    }

    // 获取链表长度
    public int getSize() {
        return size;
    }

    // 判断链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 在链表头部添加元素
    public void addFirst(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head;
        head = newNode;
        size++;
    }

    // 在链表尾部添加元素
    public void addLast(int val) {
        if (isEmpty()) {
            addFirst(val);
            return;
        }
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        ListNode newNode = new ListNode(val);
        current.next = newNode;
        size++;
    }

    // 在指定位置添加元素
    public void add(int index, int val) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == 0) {
            addFirst(val);
            return;
        }
        ListNode current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        ListNode newNode = new ListNode(val);
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }

    // 删除链表头部元素
    public int removeFirst() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }
        int val = head.val;
        head = head.next;
        size--;
        return val;
    }

    // 删除链表尾部元素
    public int removeLast() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }
        if (size == 1) {
            return removeFirst();
        }
        ListNode current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        int val = current.next.val;
        current.next = null;
        size--;
        return val;
    }

    // 删除指定位置的元素
    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == 0) {
            return removeFirst();
        }
        ListNode current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        int val = current.next.val;
        current.next = current.next.next;
        size--;
        return val;
    }

    // 获取指定位置的元素
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        ListNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.val;
    }

    // 修改指定位置的元素
    public void set(int index, int val) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        ListNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.val = val;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode current = head;
        while (current != null) {
            sb.append(current.val).append(" -> ");
            current = current.next;
        }
        sb.append("null");
        return sb.toString();
    }

}