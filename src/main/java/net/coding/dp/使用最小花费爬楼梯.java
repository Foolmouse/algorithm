package main.java.net.coding.dp;

/**
 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。

 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。

 请你计算并返回达到楼梯顶部的最低花费。



 示例 1：

 输入：cost = [10,15,20]
 输出：15
 解释：你将从下标为 1 的台阶开始。
 - 支付 15 ，向上爬两个台阶，到达楼梯顶部。
 总花费为 15 。
 示例 2：

 输入：cost = [1,100,1,1,1,100,1,1,100,1]
 输出：6
 解释：你将从下标为 0 的台阶开始。
 - 支付 1 ，向上爬两个台阶，到达下标为 2 的台阶。
 - 支付 1 ，向上爬两个台阶，到达下标为 4 的台阶。
 - 支付 1 ，向上爬两个台阶，到达下标为 6 的台阶。
 - 支付 1 ，向上爬一个台阶，到达下标为 7 的台阶。
 - 支付 1 ，向上爬两个台阶，到达下标为 9 的台阶。
 - 支付 1 ，向上爬一个台阶，到达楼梯顶部。
 总花费为 6 。


 提示：

 2 <= cost.length <= 1000
 0 <= cost[i] <= 999
 */
public class 使用最小花费爬楼梯 {

    public int minCostClimbingStairs(int[] cost) {
        //注意，台阶相当于步骤+1，用一个虚拟的位置
        //从前往后，记录当前位置花费的最小成本
        int[] result = new int[cost.length + 1];

        result[0] = 0;
        result[1] = 0;
        for (int i =2;i<result.length;i++){
            //当前位置的成本为cost[x] + result[x]
            //不能简单比较单步成本，需要计算历史总成本
            result[i] = Math.min((result[i-1] + cost[i-1]), (result[i-2]+cost[i-2]));
        }
        return result[result.length - 1];

    }

    public static void main(String[] args) {
        使用最小花费爬楼梯 xx = new 使用最小花费爬楼梯();
        System.out.println(xx.minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1}));
    }

}
