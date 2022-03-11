package net.coding.leetCode;


/**
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 不允许修改 链表。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：返回索引为 1 的链表节点
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * 示例 2：
 *
 *
 *
 * 输入：head = [1,2], pos = 0
 * 输出：返回索引为 0 的链表节点
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * 示例 3：
 *
 *
 *
 * 输入：head = [1], pos = -1
 * 输出：返回 null
 * 解释：链表中没有环。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 环形链表II {

	/**
	 * 求一个环形链表,开始成环的那个节点
	 * 快慢指针
	 */
	public ListNode hasCycle2(ListNode head) {
		ListNode quickly = head;
		ListNode slow = head;

		try {
			// 一块一慢,如果有环,终会相遇
			while (slow.next != null && quickly.next.next != null) {
				slow = slow.next;
				quickly = quickly.next.next;
				//存在相交点
				if (slow == quickly) {
					//链表是个完整的环形
					if(head == slow && head == quickly){
						return head;
					}

					//链表的头部和相交点同时走
					//必定会在环开始的节点相遇, 不明白可以看题解
					while (head.next != null && slow.next != null) {
						head=head.next;
						slow=slow.next;
						if (head == slow) {
							return slow;
						}
					}
				}
			}
		} catch (Exception e) {
			//不是链表,报 npe
			return null;
		}

		return null;
	}
}
