/**
 * description: 有1到n的货币，每种货币的个数无限多个，商品价格为m，求最小货币数
 * input：6 7
 * output： 2 （6，1）
 * */

import java.util.*;

public class SelectMoney {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        //记录钱币数
        int count = 0;
        //记录当前使用的最大币值
        int temp = n;
        // 记录当前货值使用个数
        int countCurrent;
        while(m != 0){
            countCurrent = m / temp;
            count += countCurrent;
            m = m - countCurrent*temp;
            temp = m;
        }
        System.out.println(count);
    }
}
