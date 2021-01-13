package net.coding.leetCode;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama" 输出: true 示例 2:
 * <p>
 * 输入: "race a car" 输出: false
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 验证回文串 {


    public boolean isPalindrome(String s) {
        s = s.toLowerCase();

        boolean[] math = new boolean[9];
        boolean[] word = new boolean[24];

        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                math[c - '0'] = !math[c - '0'];
            }
            if (c >= 'a' && c <= 'z') {
                word[c - 'a'] = !word[c - 'a'];
            }
        }
        for (boolean b : math) {
            if (b) return false;
        }
        for (boolean b : word) {
            if (b) return false;
        }
        return true;

    }

    public static void main(String[] args) {
        boolean[] math = new boolean[9];
        System.out.println(math);
    }


}
