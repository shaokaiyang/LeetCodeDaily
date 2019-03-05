/**
 * @author sky
 * @date 2019/03/05
 * description:牛牛和羊羊正在玩一个纸牌游戏。这个游戏一共有n张纸牌, 第i张纸牌上写着数字ai。
 *   牛牛和羊羊轮流抽牌, 牛牛先抽, 每次抽牌他们可以从纸牌堆中任意选择一张抽出, 直到纸牌被抽完。
 *   他们的得分等于他们抽到的纸牌数字总和。
 *   现在假设牛牛和羊羊都采用最优策略, 请你计算出游戏结束后牛牛得分减去羊羊得分等于多少。
 * intpu:输入包括两行。
 *   第一行包括一个正整数n(1 <= n <= 105),表示纸牌的数量。
 *   第二行包括n个正整数ai(1 <= ai <= 109),表示每张纸牌上的数字。
 * output:输出一个整数得分
 * solution：每次抽牌都抽最大的牌，所以先排序然后依次做加减法
 */

import java.util.Scanner;
import java.util.Arrays;
public class CardGame {
    public static void main(String[] args){
        int n;
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        int[] score = new int[n];
        for(int i = 0; i < n; i++){
            score[i] = input.nextInt();
        }
        Arrays.sort(score);
        int result = 0;
        while(n > 0){
            result += score[--n];
            result -= score[--n];
        }
        System.out.println(result);
    }
}
