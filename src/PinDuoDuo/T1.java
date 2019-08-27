import java.util.Arrays;
import java.util.Scanner;
public class T1 {

    public static void finMiddle(int[] nums, int min, int max, int[] nums1, int target){
        int tmp = Integer.MAX_VALUE;
        int flag = 1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > min && nums[i] < max){
                tmp = nums[i];
                flag = 2;
            }
        }
        if(flag == 2){
            nums1[target] = tmp;
            print(nums1);
        }else{
            System.out.println("NO");
        }
    }

    public static void finRight(int[] nums, int n, int[] nums1, int target){
        int tmp = Integer.MAX_VALUE;
        int flag = 1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > n){
                tmp = nums[i];
                flag = 2;
            }
        }
        if(flag == 2){
            nums1[target] = tmp;
            print(nums1);
        }else{
            System.out.println("NO");
        }
    }

    public static void finLeft(int[] nums, int n, int[] nums1, int target){
        int tmp = Integer.MAX_VALUE;
        int flag = 1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < n){
                target = nums[i];
                flag = 2;
            }
        }
        if(flag == 2){
            nums1[target] = tmp;
            print(nums1);
        }else{
            System.out.println("NO");
        }
    }

    public static void print(int[] nums){
        for(int i = 0; i < nums.length; i ++){
            if(i == nums.length - 1){
                System.out.println(nums[i]);
            }else{
                System.out.print(nums[i] + " ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] nums1 = in.nextLine().split(" ");
        String[] nums2 = in.nextLine().split(" ");
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] num1 = new int[len1];
        int[] num2 = new int[len2];
        int target = -1;
        int min = 0;
        int max = 0;
        for(int i = 0; i < len1; i++){
            num1[i] = Integer.parseInt(nums1[i]);
        }
        for(int i = 0; i < len2; i++){
            num2[i] = Integer.parseInt(nums2[i]);
        }
        Arrays.sort(num2);
        if(len1 == 1){
            System.out.println(num1[0]);
        }else if(num1[1] < num1[0]){
            target = 0;
            max = num1[1];
            finLeft(num2,max,num1,target);
        }else if (num1[len1 - 1] < num1[len1 - 2]){
            target = len1 - 1;
            min = num1[len1-2];
            finRight(num2,min,num1,target);
        }else{
            for(int i = 1; i < len1; i++){
                if(num1[i] < num1[i-1]){
                    target = i;
                    min = num1[i-1];
                    max = num1[i+1];
                }
            }
            finMiddle(num2,min,max,num1,target);
        }
    }
}