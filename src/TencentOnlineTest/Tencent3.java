
// 采用大模拟方法进行运算
import java.util.Scanner;

public class Tencent3 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m =in.nextInt();
        int[] a = new int[n];
        int sum = 0;
        int maxSite = 1;
        int sumTotal = 0;
        for(int i = 0; i < n; i++){
            a[i] = in.nextInt();
            if(a[i] > 0){
                maxSite = i + 1;
            }
            sum += a[i];
            sumTotal += a[i]*(i+2);
        }
        if(m >= sum){
            System.out.println(maxSite + 1);
        }else{
            System.out.println(sumTotal/m);
        }


    }
}
