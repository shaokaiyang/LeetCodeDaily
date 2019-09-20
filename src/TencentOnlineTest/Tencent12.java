/**
 * 给定一个整数数组，数组个数为偶数，每两个数组合并求和，求所有情况中min(max(两数和))
 * 两个数组合有很多中组合方式
 * 在一种组合方式里，会有n/2个和
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Tencent12 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int count = in.nextInt();
            int time = in.nextInt();
            for(int j = 0; j < count; j++){
                arrayList.add(time);
            }
        }
        Collections.sort(arrayList);
        int min = Integer.MAX_VALUE;
        int len = arrayList.size();
        for(int i = 0; i < len/2; i++){
            int tmp = arrayList.get(i) + arrayList.get(len - 1-i);
            if( tmp < min){
                min = tmp;
            }
        }
        System.out.println(min);


    }
}
