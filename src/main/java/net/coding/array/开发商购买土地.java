package main.java.net.coding.array;

import java.util.Scanner;

/**
 * 在一个城市区域内，被划分成了n * m个连续的区块，每个区块都拥有不同的权值，代表着其土地价值。目前，有两家开发公司，A 公司和 B 公司，希望购买这个城市区域的土地。
 *
 * 现在，需要将这个城市区域的所有区块分配给 A 公司和 B 公司。
 *
 * 然而，由于城市规划的限制，只允许将区域按横向或纵向划分成两个子区域，而且每个子区域都必须包含一个或多个区块。 为了确保公平竞争，你需要找到一种分配方式，使得 A 公司和 B 公司各自的子区域内的土地总价值之差最小。
 *
 * 注意：区块不可再分。
 *
 * 输入描述
 * 第一行输入两个正整数，代表 n 和 m。
 *
 * 接下来的 n 行，每行输出 m 个正整数。
 *
 * 输出描述
 * 请输出一个整数，代表两个子区域内土地总价值之间的最小差距。
 * 输入示例
 * 3 3
 * 1 2 3
 * 2 1 3
 * 1 2 3
 * 输出示例
 * 0
 * 提示信息
 * 如果将区域按照如下方式划分：
 *
 * 1 2 | 3
 * 2 1 | 3
 * 1 2 | 3
 *
 * 两个子区域内土地总价值之间的最小差距可以达到 0。
 *
 * 数据范围：
 *
 * 1 <= n, m <= 100；
 * n 和 m 不同时为 1。
 */
public class 开发商购买土地 {


    public void square(){
        Scanner scanner = new Scanner(System.in);
        //n行m列
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] squares = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                squares[i][j] = scanner.nextInt();
            }
        }

        //计算水平切分和竖向切分的前缀后
        //为什么不直接计算单行或者单列的和，方便数据量太大的时候，直接计算出差值
        int[] horizontal = new int[n];
        int val =0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                val += squares[i][j];
            }
            horizontal[i] = val;
        }

        val = 0;
        int[] vertical = new int[m];
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                val += squares[i][j];
            }
            vertical[j] = val;
        }


        //计算完以行切割或者以列切割，使用前缀和计算差值
        int gap = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            //在分割线上边的值 = horizontal[i-1]
            //下边的值 = horizontal[最后一个] - horizontal[i-1]
            //两者的差值为 = horizontal[n - 1] - 2*horizontal[i - 1]
            int result = Math.abs(horizontal[n - 1] - 2*horizontal[i - 1]);
            if(result < gap){
                gap = result;
            }
        }

        for (int i = 1; i < m; i++) {
            int result = Math.abs(vertical[m - 1] - 2*vertical[i - 1]);
            if(result < gap){
                gap = result;
            }
        }

        System.out.println(gap);
    }

    public static void main(String[] args) {
        开发商购买土地 xx = new 开发商购买土地();
        开发商购买土地 xx1 = xx;
        xx1.square();


    }


}
