package main.java.net.coding.array;

import main.java.net.coding.linked.NodeList;

/**
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 *
 * 示例 1:
 *
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * 示例 2:
 *
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 *
 *
 * 提示：
 *
 * 你可以假设 nums 中的所有元素是不重复的。
 * n 将在 [1, 10000]之间。
 * nums 的每个元素都将在 [-9999, 9999]之间。
 */
public class 二分查找 {


    public int search(int[] nums, int target) {
        //左闭右闭
        //0-> 最大下表
        int head = 0;
        int tail = nums.length - 1;
        while (head <= tail) {
            int mid = (tail - head)/2 + head;
            if (nums[mid] == target) {
                return mid;
            }else if (nums[mid] < target){
                //当前位置mid肯定不是target
                head = mid + 1;
            }else if (nums[mid] > target){
                tail = mid - 1;
            }
        }
        return -1;
    }

    public int search2(int[] nums, int target) {
        //左闭右闭
        //0-> 最大下表
        int head = 0;
        int tail = nums.length - 1;
        while (head <= tail) {
            int mid = (tail - head)/2 + head;
            if (nums[mid] == target) {
                return mid;
            }else if (nums[mid] < target){
                //当前位置mid肯定不是target
                head = mid + 1;

            }else if (nums[mid] > target){
                tail = mid - 1;
            }
        }
        return head ;
    }


    public static void main(String[] args) {
        二分查找 xx = new 二分查找();
        int[] ints = {-1, 0, 3, 5, 9, 12};
        System.out.println(xx.search2(ints, 1));

        // 创建一个队列
        NodeList<Integer> queue = new NodeList<Integer>();

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        // 出队操作
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }

    }
}
