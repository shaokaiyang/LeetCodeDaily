import java.util.*;

public class SerialNumber {

    public static int sumOdd(char[] nums){
        int sum = 0;
        int len = nums.length;
        for(int i = len - 1; i >= 1; i = i- 2){
            sum += (int)(nums[i] - '0');
        }
        return sum;
    }

    public static int sumOu(char[] nums){
        int sum = 0;
        int len = nums.length;
        int tmp = 0;
        for(int i = len - 2; i >= 0; i = i - 2){
            tmp = (int)(nums[i] - '0') * 2;
            sum += tmp > 9 ? tmp - 9 : tmp;
        }
        return sum;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int len = s.length();
        char[] nums = new char[len];
        nums = s.toCharArray();
        int result = sumOdd(nums) + sumOu(nums);
//        System.out.println(sumOdd(nums));
//        System.out.println(sumOu(nums));
        if(result % 10 == 0){
            System.out.println("ok");
        }else{
            System.out.println("error");
        }
    }
}
