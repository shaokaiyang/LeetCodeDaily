/**
 * 剪绳子问题。一根绳子可以任意裁剪，但是不能拼接。一共n根，要搞出来m条相等的绳子，
 * 且长度最长，结果保留两位小数。二分答案求最大值。复杂度O(nlog2^31)。
 */

import java.util.*;


public class JianShengZi implements Runnable{

    private final int mod = 1000000007, max = 100005;

    int[] arr = new int[max];

    public static void main(String[] args) {
        new Thread(null, new JianShengZi(), "thread-1", 1024*1024*10).start();
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
        int n = cin.nextInt(),m = cin.nextInt();
        double lower = 0D, higher = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            arr[i] = cin.nextInt();
        }

        while(higher - lower > 0.001){
            double mid = (lower+higher)/2;
            if(checkAns(n, m, mid)){
                lower = mid;
            }else{
                higher = mid;
            }
        }
        System.out.println(String.format("%.2f", lower));
    }

    boolean checkAns(int n, int m, double mid){
        int ans = 0;
        for(int i=0; i<n; i++){
            ans += (int)arr[i]/mid;
            if(ans >= m){
                return true;
            }
        }
        return false;
    }
}
