package main.java.net.coding.linked;


public class 反转链表 {

    public void reverse(ListNode head) {


        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp = null;
        while (cur != null) {
            tmp = cur.next;
            cur.next = pre;

            pre = cur;
            cur = tmp;
        }
    }

    public ListNode reverseList(ListNode head) {
        if(head!=null && head.next ==null){
            return head;
        }

        ListNode returnNode = reverseList(head.next);
        head.next.next = head;
        //避免成ring
        head.next = null;
        return returnNode;

    }

    public static void main(String[] args) {
        NodeList<Number> nodeList = new NodeList<Number>(1, 2, 3);
        反转链表 xx = new 反转链表();
        ListNode node = xx.reverseList(nodeList.head);
        System.out.println(node);
    }

}
