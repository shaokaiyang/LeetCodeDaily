/**
 * 给定两个元素个数相同的数组a,b.
 * 两个数组中的元素分别组合相加，求所有相加后的数的异或值。
 */

import java.util.Scanner;

public class Tencent15 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = in.nextInt();
        }
        for(int i = 0; i < n; i++){
            b[i] = in.nextInt();
        }
        int result = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                result ^= (a[i] + b[j]);
            }
        }
        System.out.println(result);


    }
}
