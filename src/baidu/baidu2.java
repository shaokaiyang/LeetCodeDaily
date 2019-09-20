import java.util.*;

public class baidu2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] nums = new int[n];
        int[] sum = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = in.nextInt();
            if(i == 0){
                sum[i] = nums[i];
            }else{
                sum[i] = sum[i-1] + nums[i];
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = m ; i<=n;i++){
            for(int j = 0; j <= n-m; j++){
                int tmp = sum[j+m-1] - sum[j] + nums[j];
                if( tmp < min){
                    min = tmp;
                }
            }
        }
        System.out.println(min);

    }
}
