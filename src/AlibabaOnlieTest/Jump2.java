import java.util.*;

public class Jump2 {

    public int jump(int[] nums){
        int cnt = 0;
        int reach = 0;
        int last = 0;
        int len = nums.length;
        for(int i = 0; i < len; i++){
            if(i > reach){
                return -1;
            }
            if(i > last){
                cnt++;
                last = reach;
            }
            reach = Math.max(reach, nums[i]+i);
        }
        return cnt;
    }

    public static void main(String[] args){
        int[] nums = new int[5];
        Scanner scanner = new Scanner(System.in);
       for(int i = 0; i < nums.length; i++){
           nums[i] = scanner.nextInt();
       }
       Jump2 jump2 = new Jump2();
       System.out.println(jump2.jump(nums));
    }

}
