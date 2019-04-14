public class AliQ1 {
    public static final int MAX = 200;

    public static void main(String[] args){
        int[] dp = new int[MAX];
        dp[0] = 2;
        dp[1] = 3;
        dp[2] = 4;
        System.out.println(1 << 32 - 1);
        for(int i = 3; i < MAX; i++){
            dp[i] = dp[i-2] + dp[i-3];
            System.out.println( i + " : " + dp[i]);
        }
    }

}
