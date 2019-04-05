import java.util.*;

public class Guaishou {

    private static int minCost = Integer.MAX_VALUE;

    public static void DFS(int[][] animal, int cur, int cost, int height, int n){
        if(height == n){
            if(cost < minCost){
                minCost = cost;
            }
            return;
        }
        if(cur < animal[0][height]){
            cost += animal[1][height];
            cur += animal[0][height];
            DFS(animal,cur,cost,height+1,n);
        }else{
            if(cost < minCost){
                DFS(animal,cur,cost,height+1,n);
                DFS(animal,cur+animal[0][height],cost+animal[1][height],height+1,n);
            }
        }

    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] animal = new int[2][n];
        for(int j = 0; j < 2; j++) {
            for (int i = 0; i < n; i++) {
                animal[j][i] = scanner.nextInt();
            }
        }
        if(n == 0){
            System.out.println(0);
        }
        if(n == 1){
            System.out.println(animal[1][0]);
        }
        DFS(animal,0,0,0,n);
        System.out.println(minCost);

    }


}
