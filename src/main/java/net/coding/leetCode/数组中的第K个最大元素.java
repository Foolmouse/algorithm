package net.coding.leetCode;

import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * <p>
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 *
 提示：

 1 <= k <= nums.length <= 104
 -104 <= nums[i] <= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 数组中的第K个最大元素 {

    /**
     * 第k个大的元素
     * 直接调用库排序
     */
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /**
     * 大顶堆
     * 全部放入之后，取出堆顶，直到第 k 次
     */
    public int findKthLargest2(int[] nums, int k) {

        /**
         * 构建一个 大顶堆
         * 堆顶的元素为最大值
         */
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2) -> o2-o1);
        for (int num : nums) {
            queue.add(num);
        }
        for (int i = 0; i < k; i++) {
            queue.poll();
        }
        return queue.poll();
    }

    /**
     * 大小为 k 的小堆顶
     * 堆满 k 个之后，堆顶的就是当前最小值
     * 如果新进来的元素大于堆顶，就取出堆顶
     * 如果新进来的元素小于堆顶，直接丢弃
     * 遍历所有元素之后，整个堆就是前 k 个最大元素
     * 因为是小顶堆，此时堆顶就是第 k 个大的元素
     */
    public int findKthLargest3(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            //堆还没满k个，直接放进来
            if(heap.size() <k){
                heap.add(num);
                continue;
            }
            //当前元素大于等于堆顶，替换
            if(num >= heap.peek()){
                heap.poll();
                heap.add(num);
            }
        }
        //返回前 k 个最大元素里最小元素，也就是堆顶
        return heap.peek();

    }


    public static void main(String[] args) {
        数组中的第K个最大元素 obj = new 数组中的第K个最大元素();
        int kthLargest2 = obj.findKthLargest2(new int[]{3, 2, 1, 5, 6, 4,2}, 2);
        System.out.println(kthLargest2);
    }


}
