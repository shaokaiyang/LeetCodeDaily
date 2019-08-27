import java.util.*;

public class yuan1 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n ; i++){
            int m = in.nextInt();
            int[] nums = new int[m];
            for(int j = 0; j < m ; j++){
                nums[j] = in.nextInt();
            }
            Arrays.sort(nums);
            int sum = 0;
            while(nums[m-3] > 0){
                sum += nums[m-3];
                nums[m-1] -= nums[m-3];
                nums[m-2] -= nums[m-3];
                nums[m-3] = 0;
                Arrays.sort(nums);
            }
            System.out.println(sum);
        }
    }
}
