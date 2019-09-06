import java.util.Scanner;

public class Tencent4 {

    public static int findMin(int[] a, int i, int j){
        int min = a[i];
        for(int k = i; k <= j; k++){
            if(a[k] < min){
                min = a[k];
            }
        }
        return min;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        int[] s = new int[n];
        int max = 0;
        int tmp = 0;
        for(int i = 0; i < n;i++){
            nums[i] = in.nextInt();
            tmp = nums[i] * nums[i];
            max = Math.max(max, tmp);
            if(i == 0){
                s[i] = nums[i];
            }else{
                s[i] = s[i-1] + nums[i];
            }
        }

        for(int i = 0; i < n ;i ++){
            for(int j = i + 1; j < n; j++){
                int minTmp = findMin(nums, i,j);
                max = Math.max(max, minTmp*(s[j] - s[i] + nums[i]));
            }
        }

        System.out.println(max);


    }
}
