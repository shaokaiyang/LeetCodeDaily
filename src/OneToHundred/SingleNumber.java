/**
 * @author shaoky
 * @date 2019/03/06
 * description:给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 输入: [2,2,1]
 * 输出: 1
 * solution:(1)使用异或运算，相同为0相异为1,0异或一个数还是该数本身，异或一个数两次原数不变；O(N)
 * （2）先对数组排序，然后进行一次遍历O(NlogN);
 * (3)使用hashmap，如果该数出现在map中就删除；
 */
 import java.util.Scanner;
 import  java.util.Arrays;

public class SingleNumber {

    public static int  singleNumber(int[] nums){
        int result = 0;
        for(int i = 0; i < nums.length; i++){
            result ^= nums[i];
        }
        return result;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[100];
        for(int i = 0; i < 7; i++){
            nums[i] = scanner.nextInt();
        }
        System.out.println(singleNumber(nums));
    }
}
