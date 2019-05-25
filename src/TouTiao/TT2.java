import java.util.*;
public class TT2 {

    public static void DFS(int[][] flag , int i, int j, int n, int m){
        flag[i][j] = 0;
//        int lenRow = flag.length;
//        int lenCol = flag[0].length;
        // 左上
        if((i - 1) >= 0 && (j - 1) >= 0 && flag[i-1][j-1] == 1){
            DFS(flag, i-1, j-1, n, m);
        }
        // 上
        if((i - 1) >= 0 && flag[i-1][j] == 1){
            DFS(flag, i-1, j, n, m);
        }

        // 右上
        if((i - 1) >= 0 && (j + 1) < m && flag[i-1][j+1] == 1){
            DFS(flag, i-1, j+1, n , m);
        }

        // 左
        if((j - 1) >= 0 && flag[i][j-1] == 1){
            DFS(flag, i, j-1,n, m);
        }

        // 右
        if( (j + 1) < m && flag[i][j+1] == 1){
            DFS(flag, i, j+1,n, m);
        }

        // 左下
        if((i + 1) < n && (j - 1) >= 0 && flag[i+1][j-1] == 1){
            DFS(flag, i+1, j-1,n, m);
        }

        // 下
        if((i + 1) < n && flag[i+1][j] == 1){
            DFS(flag, i+1, j,n, m);
        }

        // 右下
        if((i + 1) < n && (j + 1) < m && flag[i+1][j+1] == 1){
            DFS(flag, i+1, j+1,n, m);
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] flag = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j ++){
                flag[i][j] = in.nextInt();
            }
        }
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j ++){
                if(flag[i][j] == 1){
                    count ++;
                    DFS(flag, i, j, n, m);
                }
            }
        }
        System.out.println(count);
    }
}
