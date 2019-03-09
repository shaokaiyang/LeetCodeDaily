/**
 * @author sky
 * @date 2019/03/09
 * descrip:最长公共子序列，可以是不连续的。
 * 在一个字符串中删除最小个数的字符使得剩下的符号是回文字符串
 * solution：maxLen(i,j)表示字符串1左侧i个字符和字符串2左侧j个字符的最大公共子序列
 * 如果i，j相等则返回maxLen（i-1,j-1）+1;否则返回max(maxLen(i-1,j),maxLen(i,j-1))
 */
import java.util.*;

public class MaxCommonSubsequence {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.next();
        String s2 = new StringBuilder(s1).reverse().toString();
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for(int i = 0; i < s1.length(); i++){
            dp[i][0] = 0;
            dp[0][i] = 0;
        }

        for(int i = 1; i <= s1.length(); i++){
            for(int j = 1; j <= s2.length(); j++){
                dp[i][j] = (s1.charAt(i-1) == s2.charAt(j-1)) ? dp[i-1][j-1]+1 : Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }

        System.out.println(s1.length()-dp[s1.length()][s2.length()]);
        //System.out.println(s1.length() + "   " + dp[s1.length()][s2.length()]);
    }

}
