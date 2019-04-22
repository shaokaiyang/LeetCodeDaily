import java.util.*;
public class PerfectNumber {

    public static boolean isPerfectNumber(long n){
        long sum = 0;
        for(int i = 1; i <= n; i++){
            if(n % i == 0){
                sum += i * i;
            }
        }
        if((long)Math.sqrt(sum) * (long)Math.sqrt(sum) == sum){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long sum = 0;
        for(int i = 1; i < n; i++){
            if(isPerfectNumber(i)){
                sum += i;
            }
        }
        System.out.println(sum);
    }

}
