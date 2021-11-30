package net.coding.leetCode;

/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [0,1,3,4]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 *  
 * <p>
 * 限制：
 * <p>
 * 1 <= 数组长度 <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 零到n中缺失的数字 {

    /**
     * 数组长为n-1  (n-1=nums.length)，最大值也是n-1
     * <p>
     * 所以求出n-1! - sum(nums)= 缺失的数
     *
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        return (nums.length + 1) * nums.length / 2 - sum;
    }

    /**
     * 二分查找
     * <p>
     * 两个边界，0和length-1
     * nums[i] 一定大于等于 i
     * if(nums[i] > i) ,往左边继续二分
     * if(nums[i] = i) ,往右边继续二分
     *
     * @param nums
     * @return
     */
    public int missingNumber2(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int i = (l + r) / 2;
            if (nums[i] > i) {
                r = i - 1;
            } else if (nums[i] == i) {
                l = i + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        零到n中缺失的数字 obj = new 零到n中缺失的数字();
        obj.missingNumber2(new int[]{0});

    }

}
