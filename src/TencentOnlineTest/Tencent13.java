/**
 * 给定一个数组，将其分成两个数组，需要保证
 * 1.两个数组的个数差小于等于1；
 * 2.两个数组中元素的和相差最小；
 */


import java.util.Arrays;
import java.util.Scanner;

public class Tencent13 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++){
            int n = in.nextInt();
            int[] nums = new int[n];
            for(int j = 0; j < n; j++){
                nums[j] = in.nextInt();
            }
            Arrays.sort(nums);
            int sum1 = 0;
            int sum2 = 0;
            for(int j = n-1; j >= 0; j=j-2){
                if(j == 0){
                    if(sum1 > sum2){
                        sum2 += nums[j];
                    }else{
                        sum1 += nums[j];
                    }
                }else{
                    if(sum1 > sum2){
                        sum2 += nums[j];
                        sum1 += nums[j-1];
                    }else{
                        sum1 += nums[j];
                        sum2 += nums[j-1];
                    }
                }
            }

            if(sum1 > sum2){
                System.out.println(sum2 + " " + sum1);
            }else{
                System.out.println(sum1 + " " + sum2);
            }

        }


    }
}
