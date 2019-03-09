/**
 * @author sky
 * @date 2019/03/09
 * des:在不多申请内存空间的前提下将一个字符串中的大写字母后移
 */
import java.util.*;

public class BigChar {
    public static String getString(String str){
        return str.replaceAll("[A-Z]", "") + str.replaceAll("[a-z]]","");
    }

    public static void getString2(String str){
        char[] a = str.toCharArray();
        for(char c:a){
            if(c >= 'a' && c <= 'z'){
                System.out.print(c);
            }
        }
        for(char c : a){
            if(c >= 'A' && c <= 'Z'){
                System.out.print(c);
            }
        }

    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(getString(input));
        getString2(input);
    }
}
