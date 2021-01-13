package net.coding.leetCode;

/**
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "aba" 输出: True 示例 2:
 * <p>
 * 输入: "abca" 输出: True 解释: 你可以删除c字符。
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/valid-palindrome-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 验证回文字符串Ⅱ {

    public static boolean validPalindrome(String s) {
        if (s.length() <= 1) return true;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            char start = chars[i];
            char end = chars[chars.length - 1 - i];
            if (start == end) {
                continue;
            } else {
                return isHuiWen(s.substring(i + 1, chars.length - i)) || isHuiWen(s.substring(i, chars.length - i - 1));
            }
        }
        return true;
    }

    public static boolean isHuiWen(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            char start = chars[i];
            char end = chars[chars.length - 1 - i];
            if (start == end) continue;

            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(validPalindrome("abc"));
    }

}
