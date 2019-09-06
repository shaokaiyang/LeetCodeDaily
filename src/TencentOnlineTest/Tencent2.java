import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Tencent2 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        BigInteger sum1 = new BigInteger("0");
        for(int i = 0; i < n; i++){
            a[i] = in.nextInt();
            b[i] = in.nextInt();
            long tmp = b[i] * n - a[i];
            BigInteger tmp1 = new BigInteger(String.valueOf(tmp));
            sum1 = sum1.add(tmp1);
            c[i] = a[i] - b[i];
        }
        Arrays.sort(c);
        BigInteger sum2 = new BigInteger("0");
        for(int i = n-1; i >= 0; i--){
            BigInteger tmp2 = new BigInteger(String.valueOf(c[i]*(n-i)));
            sum2 = sum2.add(tmp2);
        }
        System.out.println(sum1.add(sum2));


    }
}
