import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Ali1 {

/** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static String getIndexAndLongest(String users, int k) {
        int index = -1;
        int maxGirl = 0;
        int maxCount = -1;
        int len = users.length();
        for(int i = 0; i < len ; i++){
            if(users.charAt(i) == 'b'){
                int sum = 0;
                int left = i-1 < 0 ? len - 1 : i-1;
                int right = i + 1 > len - 1 ? 0 : i+1;
                while(left != i){
                    if(users.charAt(left) == 'g'){
                        sum ++;
                        left = left-1 < 0 ? len - 1 : left-1;
                    }else{
                        break;
                    }
                }
                if(left == i){
                    if(sum > maxGirl){
                        index = i;
                    }
                }else{
                    while(right != left){
                        if(users.charAt(right) == 'g'){
                            sum ++;
                            right = right + 1 > len - 1 ? 0 : right +1;
                        }
                    }
                    if(sum > maxGirl){
                        index = i;
                    }
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < len ; i++){
            if(users.charAt(i) == 'g'){
                list.add(i);
            }
        }
        if(list.size() < k ){
            maxCount = 0;
        }else{
            int tmp = 0;
            int tmp1 = 0;
            for(int i = 0; i <= list.size()-k; i++){
                int left1 = list.get(i) - 1;
                int right1 = list.get(i) + 1;
                while(left1 != -1){
                    if(users.charAt(left1) == 'b'){
                        tmp ++;
                        left1 --;
                    }else{
                        break;
                    }
                }
                while(right1 != len){
                    if(users.charAt(right1) == 'b'){
                        tmp++;
                        right1++;
                    }else{
                        break;
                    }
                }
                tmp1 = tmp + (list.get(i+2) - list.get(i)) - k;
                if(tmp1 > maxCount){
                    maxCount = tmp1;
                }
            }
        }

        String result1 = index + " " + maxCount;
        return result1;




    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _users;
        try {
            _users = in.nextLine();
        } catch (Exception e) {
            _users = null;
        }
        int k = in.nextInt();

        res = getIndexAndLongest(_users, k);
        System.out.println(res);
    }
}