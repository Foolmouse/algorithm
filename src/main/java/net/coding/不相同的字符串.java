package main.java.net.coding;

import java.util.Scanner;

/**
 * 题目描述
 * 给定一个只包含小写字母的字符串，每次操作可以将两个相同的字母删除，然后在字符串的末尾新增任意一个小写字母。请问最少需要多少次操作，才能使字符串中所有的字母都不相同。
 * 输入描述
 * 第一行是一个整数 N，表示后续会有 N 个字符串，每个字符串占一行。
 * 输出描述
 * 对于输入的每一个字符串，你需要输出该字符串所需的最少操作次数，每个输出占一行。
 * 输入示例
 * 1
 * abab
 * 输出示例
 * 2
 * 提示信息
 * 第一次操作将两个'a'删除，并在字符串末尾新增一个'f'，字符串变为"bbf"；
 * <p>
 * 第二次操作将两个'b'删除，并在字符串末尾新增一个'b'，字符串变为"fb"；
 * <p>
 * 操作方式并不是唯一的，但是可以证明，最少操作次数为2。
 * <p>
 * 1 < N < 100；
 * 1 < S.length < 1000.
 */
public class 不相同的字符串 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            System.out.println(resolve(s));
        }
        scanner.close();
    }

    public static int resolve(String str) {
        int[] arrs = new int[26];
        for (char c : str.toCharArray()) {
            arrs[c - 'a']++;
        }
        int zeroCnt = 0;
        for (int arr : arrs) {
            if (arr == 0) zeroCnt++;
        }

        int opCnt= 0;
        while (true) {
            boolean flag = false;
            for (int i = 0; i < arrs.length; i++) {
                int cnt = arrs[i];
                if(cnt >=2){
                    flag = true;
                    if(zeroCnt >0){
                        zeroCnt--;
                        arrs[i] -=2;
                    }else{
                        arrs[i] -=1;
                    }
                    opCnt ++;
                }

            }
            if (!flag) {
                break;
            }
        }
        return opCnt;









    }

}
