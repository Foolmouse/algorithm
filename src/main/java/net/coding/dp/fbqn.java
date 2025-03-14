/**
 * 斐波那契
 */
public class fbqn {

    public int querySum(int n){

        int[] result = new int[n];
        result[0] = 0;
        result[1] = 1;

        if (n <= 1) {
            return result[n];
        }

        for(int i = 2;i<n;i++){
            result[i] = result[i - 1] + result[i - 2];
        }
        return result[n - 1];
    }



    public static void main(String[] args) {
        fbqn fbqn = new fbqn();
        System.out.println(fbqn.querySum(4));
    }


}