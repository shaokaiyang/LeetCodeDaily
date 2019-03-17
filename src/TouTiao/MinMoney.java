/**
 * description：有1024,64,16,4,1几种面值，消费n元，给了1024元，求出最小找钱张数
 * 贪心选择
 */

import java.util.Scanner;

public class MinMoney implements Runnable{

    private final int mod = 1000000007, max = 200005;
    private final int [] arr = {64, 16, 4, 1};

    public static void main(String[] args) {
        new Thread(null, new MinMoney(), "thread-1", 1024*1024*10).start();
    }

    @Override
    public void run() {
        try{
            solve();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void solve(){
        Scanner cin = new Scanner(System.in);
        int N = 1024-cin.nextInt(), ans = 0;
        for(int i=0; i<4; i++){
            ans += N/arr[i];
            N %= arr[i];
        }
        System.out.println(ans);
    }
}

