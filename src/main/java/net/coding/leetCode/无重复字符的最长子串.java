package net.coding.leetCode;

import java.util.HashMap;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 示例 4:
 * <p>
 * 输入: s = ""
 * 输出: 0
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 无重复字符的最长子串 {


    /**
     * 滑动窗口
     * 两个指针，
     * 尾指针不断向右移动，如果没有重复字符串，继续向右移动吃进来一个字符
     * 如果遇到重复的字符串，头指针向右移动，丢掉head指向的字符，如果还是重复，继续丢
     */
    public int lengthOfLongestSubstring(String s) {

        int head = 0, tail = 0, maxLength = 0;
        HashMap<Character, Object> map = new HashMap<>(32);

        while (tail <= s.length()-1) {
            char charAt = s.charAt(tail);
            if(map.containsKey(charAt)){
                map.remove(s.charAt(head));
                head++;
            }else{
                map.put(charAt,null);
                tail++;
            }

            if (map.size() > maxLength) {
                maxLength = map.size();
            }
        }
        return maxLength;


    }

    public static void main(String[] args) {
        无重复字符的最长子串 obj = new 无重复字符的最长子串();
        obj.lengthOfLongestSubstring("pwwkew");

    }
}
