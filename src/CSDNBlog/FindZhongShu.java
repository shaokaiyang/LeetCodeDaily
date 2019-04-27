import java.util.Arrays;
import java.util.*;

/**
 * 寻找一个数组中出现次数大于n/2的数
 * @author sky
 * @date 2019/4/27
 */
public class FindZhongShu {

    //摩尔投票法
    public static int findByMoer(int[] nums){
        int cur = 0;
        int cnt = 0;
        for(int n : nums){
            if(cnt == 0){
                cur = n;
            }
            //如果相同则计数加一，否则消除一组
            cnt = n == cur ? ++cnt : --cnt;
        }
        return cur;
    }

    //先排序后找
    public static int findBySort(int[] nums){
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    //使用map计数
    public static int findByMap(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        int result = 0;
        for(int n : nums){
            if(!map.containsKey(n)){
                map.put(n,1);
            }else{
                //更新计数
                map.replace(n, map.get(n) + 1);
            }
            if(map.get(n) > len / 2){
                result = n;
                break;
            }
        }
        return result;
    }

    //暴力搜索法
    public static int findByForce(int[] nums){
        int result = 0;
        int cnt = 0;
        int len = nums.length;
        for(int i = 0; i <= len / 2; i++){
            cnt = 0;
            for(int j = i; j < len; j++){
                if(nums[i] == nums[j]){
                    cnt ++;
                }
            }
            if(cnt > len / 2){
                result = nums[i];
                break;
            }
        }
        return result;
    }

    public static void main(String[] args){
        int[] nums = {2};
        System.out.println(findByForce(nums));
        System.out.println(findBySort(nums));
        System.out.println(findByMap(nums));
        System.out.println(findByMoer(nums));
    }
}
