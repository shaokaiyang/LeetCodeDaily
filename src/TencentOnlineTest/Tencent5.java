// (ai-bi)*j + bi*n -ai

import java.util.Arrays;
import java.util.Scanner;

public class Tencent5{

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        long sum1 = 0;
        for(int i = 0; i < n; i++){
            a[i] = in.nextInt();
            b[i] = in.nextInt();
            sum1 += b[i] * n - a[i];
            c[i] = a[i] - b[i];
        }
        Arrays.sort(c);
        long sum2 = 0;
        for(int i = n-1; i >= 0; i--){
            sum2 += c[i]*(n-i);
        }
        System.out.println(sum1+sum2);


    }
}
