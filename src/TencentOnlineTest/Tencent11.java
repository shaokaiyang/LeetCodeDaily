/**
 * 合法电话号码：8开头，11位
 * 操作：每次可以删除任意一个字符
 * 判断给定的字符串是否可以经过0次或多次操作变成合法电话号码
 */

import java.util.Scanner;
import java.util.*;

public class Tencent11 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++){
            int size = in.nextInt();
            in.nextLine();
            String s = in.nextLine();
            int j = 0;
            for(j = 0; j < size; j++){
                if(s.charAt(j) == '8'){
                    break;
                }
            }
            if(size - j >= 11){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }

        }


    }
}
