/**
 * @author sky
 * @date 2019/03/04
 * source:阿里巴巴2018届暑期招聘在线编程题；
 * description: 给定一个数组，里面全是正整数。数字大小表示这一步最多可以向后移动几个节点。总是从数组第一个元素开始移动。问如何移动，可以以最少步数移动到最后一个节点。
 * 举例说明，[3,4,2,1,3,1]初始状态指向3表示下一步可以移动1格，或者2格，或者3格。
 * 输入一个整数表示数组大小然后输入数组内容
 * solution：BFS,进行区间的范围移动，直到区间的最后一个值大于数组最大的位置停止。
 */
import java.util.Scanner;
public class QuickArray {

    private static int jump(int[] temp){
        int len = temp.length;
        int steps = 0;
        //recode jump steps
        int start = 0;
        int end = 0;
        while(end < len - 1){
            int max_pos = 0;
            //记录每次可以达到的最远的位置
            for(int i = start; i <=end; i++){
                int max_position = i + temp[i];
                if(max_pos < max_position){
                    max_pos = max_position;
                }
            }
            start = end + 1;
            end = max_pos;
            steps++;
            //System.out.println("本次循环后的区间为[" + start + "," + end + "]");
        }
        return steps;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int len = input.nextInt();
        int[] nums = new int[len];
        for(int i = 0; i < len; i++){
            nums[i] = input.nextInt();
        }
        System.out.println(jump(nums));
    }

}
