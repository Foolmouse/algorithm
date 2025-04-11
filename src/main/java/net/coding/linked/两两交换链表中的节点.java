package main.java.net.coding.linked;

/**
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 示例 2：
 *
 * 输入：head = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1]
 * 输出：[1]
 *
 *
 * 提示：
 *
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 */
public class 两两交换链表中的节点 {

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode virtualNode = new ListNode(-1);
        virtualNode.next = head;

        ListNode pre = virtualNode    ;
        while(head != null && head.next != null){
            //拿到3
            ListNode tmp = head.next.next;

            //
            pre.next = head.next;
            //2 指向 1
            head.next.next = head;
            //1 指向 3
            head.next = tmp;
            //指定2为pre
            pre = head;
            head = tmp;
        }
        return virtualNode.next;
    }

    public static void main(String[] args) {
        两两交换链表中的节点 xxx = new 两两交换链表中的节点();
        NodeList<Number> nodeList = new NodeList<Number>(1,2,3,4);
        ListNode node = xxx.swapPairs(nodeList.head);
        System.out.println(node);
    }


}
