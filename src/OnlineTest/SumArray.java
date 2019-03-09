/**
 * description: 有个数组特征是 i*(-1)^2,给定任意一个区间求和
 * */

import java.util.*;

public class SumArray {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int index = scanner.nextInt();
        for(int i = 0; i < index; i++){
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            if(l % 2 == 0){
                if((r - l + 1)%2 == 0){
                    System.out.println((l-r-1)/2);
                }else{
                    System.out.println((l + r)/2);
                }
            }else{
                if((r -l + 1)%2 == 0){
                    System.out.println((r - l + 1)/2);
                }else{
                    System.out.println((-l-r)/2);
                }
            }
        }


    }
}
