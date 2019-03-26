/**
 * pow(n,x)
 */
import java.util.Scanner;
public class PowTest50 {

    public static double pow(double x , int n){
        double res = 1.0;
        for(int i = n; i!=0; i/=2){
            if(i % 2 != 0){
                res *= x;
            }
            x *= x;
        }
        return n <0 ? 1/res : res;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        double x = scanner.nextDouble();
        int n = scanner.nextInt();
        System.out.println(pow(x,n));
        System.out.println(Math.pow(x,n));
    }
}
