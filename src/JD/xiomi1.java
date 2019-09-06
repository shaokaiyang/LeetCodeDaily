import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class xiomi1 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int solution(int[] prices, int budget) {
        int len = prices.length;
        int[] dp = new int[budget+1];
        dp[0] = Integer.MAX_VALUE;
        for(int i = 0; i < len; i++){
            if(prices[i] <= budget){
                dp[prices[i]] = 1;
            }

        }
    for(int i = 0; i <= budget; i++){
        if(dp[i] != 1){
            dp[i] = Integer.MAX_VALUE;
        }
            for(int j = 0; j < len; j++){
                if(i - prices[j] > 0){
                    if(dp[i-prices[j]] != 0 && dp[i-prices[j]] + 1 < dp[i]){
                        dp[i] = dp[i-prices[j]] + 1;
                    }
                }
            }

        }
        if(dp[budget] == Integer.MAX_VALUE){
            return -1;
        }else{
            return dp[budget];
        }


    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _prices_size = 0;
        _prices_size = Integer.parseInt(in.nextLine().trim());
        int[] _prices = new int[_prices_size];
        int _prices_item;
        for(int _prices_i = 0; _prices_i < _prices_size; _prices_i++) {
            _prices_item = Integer.parseInt(in.nextLine().trim());
            _prices[_prices_i] = _prices_item;
        }

        int _budget;
        _budget = Integer.parseInt(in.nextLine().trim());

        res = solution(_prices, _budget);
        System.out.println(String.valueOf(res));

    }
}
