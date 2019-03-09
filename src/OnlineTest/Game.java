/**
 * description: 找符合的排列，两人玩石头剪刀布游戏，每次赢了得1分，一个人的出发序列给定分数给定。
 * 求另一个人的出发序列排列数，数值mod 1000000007;
 * input: 3 2
 * 0 1 2
 * output:6
 * */
import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.*;

public class Game{
    final static int MAX_NUMBER = 1000000007;
    final static int CARD_NUMBER = 2002;
    final static int SCORE_NUMBER = 2002;

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        //求解2000以内所有的组合数以便后续运算
        long [][] CombNumber = new long[CARD_NUMBER][SCORE_NUMBER];
        for(int i = 0; i < CARD_NUMBER; i++){
            // 对角线上的元素为1，组合数定义
            CombNumber[i][i] = 1;
            //取0个元素的个数为1
            CombNumber[i][0] = 1;
        }
        for(int i = 1; i < CARD_NUMBER; i++){
            for(int j = 1; j < i; j++){
                CombNumber[i][j] = (CombNumber[i-1][j-1] + CombNumber[i-1][j]) % MAX_NUMBER;
            }
        }

        //预先计算2^0 - 2^2000，保存在数组中
        int[] PowNumber = new int[CARD_NUMBER];
        PowNumber[0] = 1;
        for(int i = 1; i < CARD_NUMBER; i++){
            PowNumber[i] = (PowNumber[i-1]*2) % MAX_NUMBER;
        }

        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int[] number = new int[n];
        for(int i = 0; i < n; i++){
            number[i] = scanner.nextInt();
        }
        //保存最终结果
        long count = CombNumber[n][s];
        /*
        n -= s;
        while(n != 0){
            count = (count*2 > MAX_NUMBER) ? (count*2) % MAX_NUMBER : count*2;
            n--;
        }
        */
        System.out.println((count*PowNumber[n-s]) % MAX_NUMBER);
    }
}
