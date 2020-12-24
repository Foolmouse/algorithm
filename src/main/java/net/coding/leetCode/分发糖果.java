package net.coding.leetCode;

/**
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 * <p>
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 * <p>
 * 每个孩子至少分配到 1 个糖果。
 * 相邻的孩子中，评分高的孩子必须获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,0,2]
 * 输出: 5
 * 解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
 * 示例 2:
 * <p>
 * 输入: [1,2,2]
 * 输出: 4
 * 解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
 * 第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/candy
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 分发糖果 {

    /**
     * 我们可以将「相邻的孩子中，评分高的孩子必须获得更多的糖果」这句话拆分为两个规则，分别处理。
     * 左规则：当 \textit{ratings}[i - 1] < \textit{ratings}[i]ratings[i−1]<ratings[i] 时，ii 号学生的糖果数量将比 i - 1i−1 号孩子的糖果数量多。
     * 右规则：当 \textit{ratings}[i] > \textit{ratings}[i + 1]ratings[i]>ratings[i+1] 时，ii 号学生的糖果数量将比 i + 1i+1 号孩子的糖果数量多。
     * 两次循环处理，第二次循环要考虑两边的值
     */
    public static int candy(int[] ratings) {

        //二维数字， 下标0=分数，1=糖果
        int[][] matrix = new int[ratings.length][2];
        for (int i = 0; i < ratings.length; i++) {
            matrix[i][0] = ratings[i];
            matrix[i][1] = 1;
        }

        //正循环
        for (int i = 0; i < matrix.length - 1; i++) {
            int left = matrix[i][0];
            int right = matrix[i + 1][0];
            // 右边比左边大，则+1
            if (right > left) {
                matrix[i + 1][1] = matrix[i][1] + 1;
            }
        }

        //倒过来循环一遍
        for (int i = matrix.length - 2; i >= 0; i--) {
            //处理左边边界
            int left = matrix[i][0];
            if (i > 0) {
                left = matrix[i - 1][0];
            }

            int mid = matrix[i][0];
            int right = matrix[i + 1][0];

            //中间比两边都大，取最大+1
            if (mid > right && mid > left) {
                matrix[i][1] = Math.max(matrix[i - 1][1], matrix[i + 1][1]) + 1;
            } else if (mid > right) {
                matrix[i][1] = matrix[i + 1][1] + 1;
            }
        }

        int result = 0;
        for (int[] trix : matrix) {
            result += trix[1];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 2};
        System.out.println(candy(arr));

    }

}
