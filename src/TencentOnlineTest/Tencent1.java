
import java.util.*;
public class Tencent1 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        int[] b =new int[m];
        //奇数个数
        int x1 = 0;
        //偶数个数
        int y1 = 0;
        int x2 = 0;
        int y2 = 0;
        for(int i = 0; i < n ;i ++){
            a[i] = in.nextInt();
            if((a[i] & 1) == 1){
                x1 ++;
            }else{
                y1 ++;
            }
        }
        for(int i = 0; i< m;i ++){
            b[i] = in.nextInt();
            if((b[i] & 1) == 1){
                x2 ++;
            }else{
                y2 ++;
            }
        }

        System.out.println(Math.min(x1,y2) + Math.min(x2,y1));


    }
}
