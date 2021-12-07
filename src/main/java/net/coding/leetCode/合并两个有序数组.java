package net.coding.leetCode;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * <p>
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * <p>
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
 * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 * 示例 2：
 * <p>
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 * 解释：需要合并 [1] 和 [] 。
 * 合并结果是 [1] 。
 * 示例 3：
 * <p>
 * 输入：nums1 = [0], m = 0, nums2 = [1], n = 1
 * 输出：[1]
 * 解释：需要合并的数组是 [] 和 [1] 。
 * 合并结果是 [1] 。
 * 注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。
 *  
 * <p>
 * 提示：
 * <p>
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[j] <= 109
 *  
 * <p>
 * 进阶：你可以设计实现一个时间复杂度为 O(m + n) 的算法解决此问题吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 合并两个有序数组 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            //copy nums2 to nums1
            for (int i = 0; i < nums2.length; i++) {
                nums1[i] = nums2[i];
            }
        }
        if (n == 0) {
            // do no thing
            return;
        }
        //将两个数组都放到map
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            map.putIfAbsent(nums1[i], 0);
            map.computeIfPresent(nums1[i], (key, value) -> ++value);
        }
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(nums2[i], 0);
            map.computeIfPresent(nums2[i], (key, value) -> ++value);
        }
        int index = 0;
        for (int i = -109; i <= 109; i++) {
            if (!map.containsKey(i))
                continue;
            Integer count = map.get(i);
            for (int j = 0; j < count; j++) {
                nums1[index] = i;
                index++;
            }
        }

    }

    public static void main(String[] args) {
        合并两个有序数组 obj = new 合并两个有序数组();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        obj.merge(nums1, 3, new int[]{2, 3, 4}, 3);

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.computeIfPresent(1, (key, value) -> ++value);
//        map.computeIfAbsent(1, (value) -> 0);
        System.out.println(map.get(1));
    }

}
