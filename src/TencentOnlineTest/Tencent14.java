/**
 * 给定一个数组，定义一轮操作：
 * 找到非0最小值输出，并将所有元素都减去这个最小值
 *如果所有元素都是0则输出0
 *
 * 输出每一轮的值
 */


import java.util.Arrays;
import java.util.Scanner;

public class Tencent14 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n ;i++){
            nums[i] = in.nextInt();
        }
        Arrays.sort(nums);
        int minSum = 0;
        int minIndex = 0;
        int min = 0;
        for(int i = 1; i <= k;){
            if( minIndex > n-1){
                System.out.println(0);
            }else{
                min = nums[minIndex] - minSum;
                minSum += min;
                while(nums[minIndex] - minSum <= 0){
                    minIndex ++;
                }
                if(min > 0){
                    System.out.println(min);
                    i ++;
                }

            }

        }


    }
}
