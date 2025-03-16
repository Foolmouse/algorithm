import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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



    private static void backtrack(String[] items, int index, List<String> current, List<List<String>> result) {
        // 终止条件：如果已经处理完所有物品，将当前组合加入结果列表
        if (index == items.length) {
            result.add(new ArrayList<>(current)); // 添加到结果
            return;
        }

        // 不取当前物品
        backtrack(items, index + 1, current, result);

        // 取当前物品
        current.add(items[index]); // 选择当前物品
        backtrack(items, index + 1, current, result); // 递归处理下一个物品
        current.remove(current.size() - 1); // 撤销选择（回溯）
    }

    public static void main(String[] args) {
        String[] items = {"A", "B", "C"};
        List<List<String>> combinations = generateCombinations(items);

        // 输出所有组合
        for (List<String> combination : combinations) {
            System.out.println(combination);
        }
    }

    /**
     * 生成所有组合
     * @param items 物品数组
     * @return 所有组合的列表
     */
    public static List<List<String>> generateCombinations(String[] items) {
        List<List<String>> result = new ArrayList<>();
        backtrack(items, 0, new ArrayList<>(), result);
        return result;
    }



//
//    public static void main(String[] args) {
//
//        //到第n级台阶时，共有解法 = dp(i-1) + dp(i-2)
//        //dp[1]=1
//        //dp[2]=2
//
//        爬楼梯 xxx = new 爬楼梯();
//
//        System.out.println(Arrays.toString(xxx.step(5)));
//    }


}