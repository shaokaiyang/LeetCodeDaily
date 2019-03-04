/**
 * @author sky
 * @date 2019/03/04
 * source:阿里巴巴2018届暑期招聘在线编程题；
 * description: 有一排桃树，每棵树最多摘一个，而且一旦摘了一棵树的桃子，就不能再摘比这棵树结的桃子少的树上的桃子了，那么小猴子最多能摘几个桃子呢？
 * 举例说明，比如有5课树，分别结了10,4,5,12,8颗桃子，那么小猴子最多能摘3颗桃子，来自于结了4,5,8（4,5,12）颗桃子的树。
 * solution：动态规划o(n^2)
 * 状态转移方程：dp(i)=max{1, dp(j)+1} 其中 j 只要 满足V[i]>V[j]且 j在[0，i-1]区间内 就行 所以 dp(j)+1 的个数>=0;
 */

import java.util.Scanner;
public class MonkeyPickPeaches {

    static int pick(int[] peaches){
        int max = 1;
        //记录每个位置的最长递增子序列
        int result[] = new int[peaches.length];

        for(int i = 0; i < peaches.length; i++){
            result[i] = 1;
            for(int j = 0; j < i; j++){
                if(peaches[j] <= peaches[i] && result[j] + 1 > result[i]){
                    result[i] += 1;
                }
            }
           // System.out.println((i+1) + "位置最大可摘桃子数" + result[i]);
        }
        for(int i : result){
            max = i > max ? i : max;
        }
        return max;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int trees = input.nextInt();
        int[] peaches = new int[trees];
        for(int i = 0; i < trees; i++){
            peaches[i] = input.nextInt();
        }
        System.out.println(pick(peaches));
    }
}
