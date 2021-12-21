package net.coding.leetCode;

/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 * <p>
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：num1 = "11", num2 = "123"
 * 输出："134"
 * 示例 2：
 * <p>
 * 输入：num1 = "456", num2 = "77"
 * 输出："533"
 * 示例 3：
 * <p>
 * 输入：num1 = "0", num2 = "0"
 * 输出："0"
 *  
 * <p>
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= num1.length, num2.length <= 104
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 字符串相加 {

    public String addStrings(String num1, String num2) {

        int max = Math.max(num1.length(), num2.length());

        String mid = num1.length() > num2.length() ? num1 : num2;

        if (num1.length() > num2.length()) {
            String zero = "";
            for (int i = 0; i < num1.length() - num2.length(); i++) {
                zero += "0";
            }
            num2 = zero + num2;
        } else if (num1.length() < num2.length()) {
            String zero = "";
            for (int i = 0; i < num2.length() - num1.length(); i++) {
                zero += "0";
            }
            num1 = zero + num1;
        }

        StringBuilder builder = new StringBuilder();
        int carry = 0;
        for (int i = num1.length()-1; i >=0 ; i--) {
            char charOne = num1.charAt(i);
            char charTwo = num2.charAt(i);

            int result = charOne - '0' + charTwo - '0' + carry;
            builder.append(result % 10);
            if (result >= 10) {
                carry = 1;
            }else{
                carry = 0;
            }
        }
        if (carry > 0) {
            builder.append(carry);
        }
        return builder.reverse().toString();

    }

}
