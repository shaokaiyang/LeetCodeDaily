
import java.util.*;

public class baidu1 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = in.nextInt();
        }
        int min = Integer.MAX_VALUE;
        int start = 0;
        int sum = 0;
        for(int i = 0 ; i < n; i++){
            if(sum <= 0){
                sum += nums[i];
            }else{
                sum = nums[i];
                start = i;
            }
            if(sum < min && i - start > m-1){
                min = sum;
            }
        }
        System.out.println(min);

    }
}
