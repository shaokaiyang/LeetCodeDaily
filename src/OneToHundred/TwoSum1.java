import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author sky
 * @date 2018/0114
 * description: 给一个整形数组和一个目标值，找出和为目标值的两数索引；
 * solution：值和数组索引用hashmap进行存储，一遍遍历
 */

public class TwoSum1 {
    public int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int result = target - nums[i];
            if(map.containsKey(result)){
                return new int[]{map.get(result), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int[] nums = new int[5];
        int target = 0;
        for(int i = 0; i < 5; i++){
            if(scan.hasNextInt()){
                nums[i] = scan.nextInt();
            }
        }
        if(scan.hasNextInt()){
            target = scan.nextInt();
        }
        scan.close();
        int[] result = new TwoSum1().twoSum(nums, target);
        for(int i : result){
            System.out.println(i);
        }
    }


}
