package net.coding.leetCode;

import java.util.HashMap;

public class 最长回文串 {


    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>(1 >> 6);
        for (char c : s.toCharArray()) {
            map.put(c, map.get(c) == null ? 1 : map.get(c) + 1);
        }
        int result = 0;
        boolean isCore = false;
        for (Integer value : map.values()) {
            if (value % 2 == 0) {
                //偶数字符
                result += value;
            } else {
                //奇数字符
                if (!isCore) {
                    isCore = true;
                    result += value;
                } else {
                    result = result + value - 1;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println('A' == 'a');
        System.out.println('1'+1);
        System.out.println(' '+1);
        System.out.println('A' + 1);
        System.out.println('a' + 1);
    }
}
