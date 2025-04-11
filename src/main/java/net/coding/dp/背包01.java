package main.java.net.coding.dp;

import java.util.function.DoublePredicate;

/**
 * 题目描述
 * 小明是一位科学家，他需要参加一场重要的国际科学大会，以展示自己的最新研究成果。他需要带一些研究材料，但是他的行李箱空间有限。这些研究材料包括实验设备、文献资料和实验样本等等，它们各自占据不同的空间，并且具有不同的价值。
 *
 * 小明的行李空间为 N，问小明应该如何抉择，才能携带最大价值的研究材料，每种研究材料只能选择一次，并且只有选与不选两种选择，不能进行切割。
 *
 * 输入描述
 * 第一行包含两个正整数，第一个整数 M 代表研究材料的种类，第二个正整数 N，代表小明的行李空间。
 *
 * 第二行包含 M 个正整数，代表每种研究材料的所占空间。
 *
 * 第三行包含 M 个正整数，代表每种研究材料的价值。
 *
 * 输出描述
 * 输出一个整数，代表小明能够携带的研究材料的最大价值。
 * 输入示例
 * 6 1
 * 2 2 3 1 5 2
 * 2 3 1 5 4 3
 * 输出示例
 * 5
 * 提示信息
 * 小明能够携带 6 种研究材料，但是行李空间只有 1，而占用空间为 1 的研究材料价值为 5，所以最终答案输出 5。
 *
 * 数据范围：
 * 1 <= N <= 5000
 * 1 <= M <= 5000
 * 研究材料占用空间和价值都小于等于 1000
 */
public class 背包01 {


    /**
     * 对每个物品独立求解，都有两种可能，放或者不放
     * @param weight
     * @param value
     * @param space
     * @return
     */
    public int pack(int[] weight, int[] value, int space){
        //dp[i][j]的定义要注意，代表在第i个物品，j背包容量下，能得的最大价值
        int[][] dp = new int[weight.length][space+1];
        //init border
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < space+1; j++) {
                //0容量下都为0
                if (j >= weight[i]) {
                    dp[i][j] = value[i];
                } else {
                    dp[i][j] = 0;
                }
                //对每个物品独立求解，都有两种可能，放或者不放
                //不放 = dp[i-1][j]

                //放,等于在扣减当前物品重量后，剩余空间能得到的最大价值. 再加上当前物品的价值
                //不需要考虑其他物品放还是不放，每个物品都是独立的 dp[i - 1][j - weight[i]] + value[i];
                if (j < weight[i]) {
                    //当前背包放不下i
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }
        return dp[weight.length - 1][space];
    }


    public static void main(String[] args) {
        Thread t1 = new Thread();
        System.out.println(t1.isDaemon());
        t1.setDaemon(true);
        System.out.println(t1.isDaemon());
        t1.start();
        t1.setDaemon(false);
    }



}
