/**
 * description:在一个序列中找包含N个整数的最小区间；
 * solution: 维护一个队列若颜色没有出现完则直接加入；
 * 若颜色够且与队首颜色相同则将该颜色入队，将队首所有相同颜色出队；
 * 每次当颜色够时维护一个最小符合要求数；
 * 如果遇到0则清空队列，继续执行；
 */

import java.util.*;

public class AirBoll{
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        if(n < m){
            System.out.println(-1);
        }
        int[] color = new int[n];
        // 用于标记该颜色是否出现过
        int[] colorBase = new int[m];
        for(int i = 0; i < m; i++){
            colorBase[i] = 0;
        }
        for(int i = 0; i < n; i++){
            color[i] = scanner.nextInt();
        }













    }
}
