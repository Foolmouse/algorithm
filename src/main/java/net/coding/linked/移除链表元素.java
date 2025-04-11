package main.java.net.coding.linked;

/**
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * 示例 2：
 *
 * 输入：head = [], val = 1
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 */
public class 移除链表元素 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode result;

        //移除头节点
        while(head !=null && head.val == val){
            head = head.next;
        }
        result = head;

        //判断下个结果是否为null
//        while(head.next !=null){
        while(head !=null && head.next !=null){
            if(head.next.val == val){
                head.next = head.next.next;
            }else{
                head = head.next;
            }

        }
        return result;
    }


    //虚拟头节点做法
    public ListNode removeElements2(ListNode head, int val) {
        ListNode node = new ListNode(-1);

        node.next = head;

        ListNode cur = node;

        while(cur.next !=null ){
            if(cur.next.val == val){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return node.next;


    }

    public static void main(String[] args) {
        java.util.List<Integer> values = java.util.Arrays.asList(1,2,2,1);
        NodeList<Number> list = new NodeList<Number>(values);
        移除链表元素 xxx = new 移除链表元素();
        System.out.println(xxx.removeElements(list.head,2));
    }
}
