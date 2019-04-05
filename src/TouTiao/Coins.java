import java.util.*;

public class Coins {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[] coins = new int[n];
        for(int i = 0; i < n; i++){
            coins[i] = scanner.nextInt();
        }
        Arrays.sort(coins);
       // System.out.println(coins);
        if(coins[0] != 1) {
            System.out.println(-1);
        }

        int sum=0,ans=0;
        while(true) {
            if (sum >= m) {
                System.out.println(ans);
                return;
            }
            for (int i = n-1; i >= 0; i--) {
                if (coins[i] <= sum + 1) {
                    sum += coins[i];
                    ans++;
                    break;
                }
            }
        }


    }


}
