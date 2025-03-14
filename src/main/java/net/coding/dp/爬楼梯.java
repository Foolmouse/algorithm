import java.util.Arrays;

public class 爬楼梯 {



    public int[] step(int n ){

//        if (n <= 2) {
//            return n;
//        }

        int[] result = new int[n];
        result[0] = 1;
        result[1] = 2;

        for (int i = 2; i < result.length; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
//        return result[n-1];
        return result;
    }


    public static void main(String[] args) {

        //到第n级台阶时，共有解法 = dp(i-1) + dp(i-2)
        //dp[1]=1
        //dp[2]=2

        爬楼梯 xxx = new 爬楼梯();

        System.out.println(Arrays.toString(xxx.step(5)));
    }


}