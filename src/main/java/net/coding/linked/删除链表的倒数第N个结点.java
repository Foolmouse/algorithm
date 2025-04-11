package main.java.net.coding.linked;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 * <p>
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 */
public class 删除链表的倒数第N个结点 {

    int cnt = 0;

    /**
     * 递归
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        ListNode returnNode = removeNthFromEnd(head.next, n);
        cnt++;
        if (n == cnt) {
            return returnNode;
        }
        head.next = returnNode;
        return head;
    }

    /**
     * 双指针
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {

        ListNode virtualNode = new ListNode(-1);
        virtualNode.next = head;

        ListNode fast = virtualNode;
        ListNode slow = virtualNode;
        for (int i = 1; i <= n; i++) {
            fast = fast.next;
        }
        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return virtualNode.next;
    }


    public static void main(String[] args) {
        NodeList<Number> nodeList = new NodeList<Number>(1,2,3,4,5);
        删除链表的倒数第N个结点 xxx = new 删除链表的倒数第N个结点();
//        ListNode node = xxx.removeNthFromEnd(linkedList.head, 1);
        ListNode node = xxx.removeNthFromEnd2(nodeList.head, 1);
        System.out.println(node);
    }


}
