/**
 * 发奖品问题。n个人的分数围成一个环，任何一个人获得的奖品数量都比左右两个分数比自己低的人多
 * 分数相等的话没有要求，求最小需要多少个奖品。设dp[i]表示给i发的最小奖品，首先扫一遍数组，
 * 将两侧分数均比中间高的位置，奖品数置1，然后再扫一遍对没有赋值的位置进行递归记忆化搜索。
 * 复杂度O(N)
 * ---------------------
 *
 */

import java.util.*;

public class FaJiangPin implements Runnable{

    private final int mod = 1000000007, max = 100005;

    int[] arr = new int[max], dp = new int[max];

    public static void main(String[] args) {
        new Thread(null, new FaJiangPin(), "thread-1", 1024*1024*10).start();
    }

    @Override
    public void run() {
        try{
            solve();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void solve() {
        Scanner cin = new Scanner(System.in);
        int T = cin.nextInt();
        for(int i=0; i<T; i++){
            int n = cin.nextInt();
            for(int j=0; j<n; j++){
                arr[j] = cin.nextInt();
                dp[j] = 0;
                //初始化dp数组
            }
            for(int j=0; j<n; j++){
                if(arr[(j+1)%n] >= arr[j] && arr[(j-1+n)%n] >= arr[j]){
                    // 最优情况下，这里发的奖品一定是1
                    dp[j] = 1;
                }
            }

            long ans = 0;
            for(int j=0; j<n; j++){
                if(dp[j] == 0){
                    dfs(j, n);
                }
                ans += dp[j];
            }
            System.out.println(ans);
        }
    }

    /**
     * 每次寻找两边最小的找，然后加1；
     * @param k
     * @param n
     */
    void dfs(int k, int n) {
        int pre = (k-1+n)%n, nex = (k+1)%n;
        if(arr[pre] < arr[k] && dp[pre] == 0){
            dfs(pre, n);
        }
        if(arr[nex] < arr[k] && dp[nex] == 0){
            dfs(nex, n);
        }

        if(arr[pre] < arr[k]){
            dp[k] = Math.max(dp[k], dp[pre]+1);
        }
        if(arr[nex] < arr[k]){
            dp[k] = Math.max(dp[k], dp[nex]+1);
        }
    }
}
