package main.java.net.coding.array;

public class 长度最小的子数组 {

    public int minSubArrayLen(int target, int[] nums) {
        int val = 0;
        int tail = 0;
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            val += nums[i];
            while (val >= target) {
                if (i - tail < minLength) {
                    minLength = i - tail;
                }
                val -= nums[tail];
                tail++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength+1;
    }
}
