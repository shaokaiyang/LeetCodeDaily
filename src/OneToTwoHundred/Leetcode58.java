/**
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 *
 * 如果不存在最后一个单词，请返回 0 。
 *
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 */



import java.util.*;
public class Leetcode58 {
    public static int lengthOfLastWord(String s){
        String tmp = s.trim();
        if(tmp.length() == 0){
            return 0;
        }else{
            int len = tmp.length();
            int index = len - 1;
            while(index >= 0 && tmp.charAt(index) != ' '){
                index --;
            }
            return len - index - 1;
        }
    }

    public static int lengthOfLastWordTest(String s){
        String[] strings = s.split(" ");
        if(strings.length == 0){
            return 0;
        }else{
            return strings[strings.length - 1].length();
        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(lengthOfLastWord(s));
        System.out.println(lengthOfLastWordTest(s));
    }
}
