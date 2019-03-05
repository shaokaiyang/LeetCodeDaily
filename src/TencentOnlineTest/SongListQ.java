/**
 * @author sky
 * @date 2019/03/05
 * description:小Q有X首长度为A的不同的歌和Y首长度为B的不同的歌，现在小Q想用这些歌组成一个总长度正好为K的歌单，
 * 每首歌最多只能在歌单中出现一次，在不考虑歌单内歌曲的先后顺序的情况下，请问有多少种组成歌单的方法。
 * input:每个输入包含一个测试用例。
 *   每个测试用例的第一行包含一个整数，表示歌单的总长度K(1<=K<=1000)。
 *   接下来的一行包含四个正整数，分别表示歌的第一种长度A(A<=10)和数量X(X<=100)以及歌的第二种长度B(B<=10)和数量Y(Y<=100)。保证A不等于B。
 * output:输出一个整数,表示组成歌单的方法取模。因为答案可能会很大,输出对1000000007取模的结果。
 * solution:本题首先需要确定多少个A和多少个B能组成和为K的数，然后求C(X, A) 和C(Y, B)的积，C(X, A)为从X个数中抽取A个数的种类。
 */

import java.util.Scanner;

public class SongListQ {

    static final long MODEL = 1000000007;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        int songALength = scanner.nextInt();
        int songANumber = scanner.nextInt();
        int songBLength = scanner.nextInt();
        int songBNumber = scanner.nextInt();
        long sum = 0;

        //求解所有的组合数
        long[][] CombinationNumber = new long[102][102];
        for(int i = 0; i < 102; i++){
            CombinationNumber[i][i] = 1; //对角线上的元素为1
            CombinationNumber[i][0] = 1; //取0个元素的个数为1
        }
        for(int i = 1; i < 102; i++){
            for(int j = 1; j < i; j++){
                CombinationNumber[i][j] = (CombinationNumber[i-1][j-1] + CombinationNumber[i-1][j]) % MODEL;
            }
        }

        //int step = songALength > songBLength ? songALength : songBLength;
        for(int i = 0; i <= songANumber; i++){
            //A歌的当前总长度要小于等于总长度；剩下的长度要能够被B歌整除；剩下长度所需的B歌数量要小于等于给定值；
            if(i * songALength <= total && (total - i * songALength) % songBLength == 0 && (total - i * songALength) / songBLength <= songBNumber){
                sum = (sum + (CombinationNumber[songANumber][i] * CombinationNumber[songBNumber][(total - i * songALength) / songBLength]) % MODEL )% MODEL;
                //i += step;
            }
        }
        System.out.println(sum);
    }
}
