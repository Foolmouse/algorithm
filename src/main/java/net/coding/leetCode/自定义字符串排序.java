package net.coding.leetCode;


/**
 * 字符串S和 T 只包含小写字符。在S中，所有字符只会出现一次。
 * <p>
 * S 已经根据某种规则进行了排序。我们要根据S中的字符顺序对T进行排序。更具体地说，如果S中x在y之前出现，那么返回的字符串中x也应出现在y之前。
 * <p>
 * 返回任意一种符合条件的字符串T。
 * <p>
 * 示例: 输入: S = "cba" T = "abcd" 输出: "cbad" 解释: S中出现了字符 "a", "b", "c", 所以 "a", "b", "c" 的顺序应该是 "c",
 * "b", "a". 由于 "d" 没有在S中出现, 它可以放在T的任意位置. "dcba", "cdba", "cbda" 都是合法的输出。 注意:
 * <p>
 * S的最大长度为26，其中没有重复的字符。 T的最大长度为200。 S和T只包含小写字符。
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/custom-sort-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 自定义字符串排序 {

    public String customSortString(String S, String T) {
        int[] charArr = new int[26];
        for (int i = 0; i < T.length(); i++) {
            int charIndex = T.charAt(i);
            charArr[charIndex - 'a'] = charArr[charIndex - 'a'] + 1;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char charIndex = S.charAt(i);

            //拿到字符串,取出重复次数,清空为 0
            int i1 = charArr[charIndex - 'a'];
            appendString(stringBuilder, charIndex, i1);
            charArr[charIndex - 'a'] = 0;
        }

        //如果还有没排序的字符,随便加到后面
        for (int i = 0; i < charArr.length; i++) {
            int i1 = charArr[i];
            if (i1 != 0) {
                int i2 = i + 'a';
                appendString(stringBuilder, (char) i2, i1);
            }
        }
        return stringBuilder.toString();
    }

    private void appendString(StringBuilder stringBuilder, char charIndex, int i1) {
        for (int j = 0; j < i1; j++) {
            stringBuilder.append(charIndex);
        }
    }


}
