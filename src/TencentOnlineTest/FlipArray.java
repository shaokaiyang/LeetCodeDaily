/**
        * @author sky
        * @date 2019/03/04
        * source:腾讯2018春招技术类编程题
        * description: 给定整数n和m, 满足n能被2m整除。对于一串连续递增整数数列1, 2, 3, 4…, 每隔m个符号翻转一次, 最初符号为’-‘;。
        * 例如n = 8, m = 2, 数列就是: -1, -2, +3, +4, -5, -6, +7, +8.
        * 而n = 4, m = 1, 数列就是: -1, +2, -3, + 4.
        * 小Q现在希望你能帮他算算前n项和为多少。
        * solution：直接找规律推导，每2m个数为一个单元，每个单元的和是相同的为m^2；所以结果为n*m/2;
        */
import java.util.Scanner;

public class FlipArray {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n, m;
        n = input.nextInt();
        m = input.nextInt();
        System.out.println(n * m / 2);
    }
}
