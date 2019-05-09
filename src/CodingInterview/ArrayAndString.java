import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 程序员面试金典中的题目
 * 本主要主要是数组和字符窜操作
 * @author sky
 * @date 2019/5/8
 */
public class ArrayAndString {

    /**
     * 题目：1.1 确定一个字符串的所有字符是否全部相同，不使用额外的数据结构。
     * 思路：假定使用ASCII进行编码，总共有256个字符，可以构建一个布尔类型的数据来标记。
     * 2019/5/9   sky
     * time:o(n)
     * space：o(1)
     */
    public static boolean isUniqueChar(char[] chars){
        if(chars.length > 256){
            return false;
        }
        boolean[] charSet = new boolean[256];
        for(int i = 0; i < chars.length; i++){
            if(charSet[chars[i]]){
                return false;
            }
            charSet[chars[i]] = true;
        }
        return true;
    }

    /**
     * 思路：采用位运算的方式可以将辅助空间缩短8倍，因为一个字节可以存储8个字符的状态
     * 这里假设字符为a-z，其他形式的只要进行扩展即可；
     */
    public static boolean isUniqueCharByBit(char[] chars){
        if(chars.length > 26){
            return false;
        }
        // 标记是否存在过，int是32位的，可以存储32个状态
        int checker = 0;
        for(int i = 0; i < chars.length; i++){
            int val = chars[i] - 'a'; // 转化为数字
            if((checker & (1 << val)) > 0){
                return false;
            }
            checker |= (1 << val);
        }
        return true;
    }

    /**
     * 判断一个字符串是否可以通过排序变成另外一个字符串
     */
    public static String stringSort(String s){
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static boolean isSame(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }
        return stringSort(s1).equals(stringSort(s2));
    }

    /**
     * 通过hashmap实现
     */
    public static boolean isSame1(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for(int i = 0; i < s1.length(); i++){
            char temp = s1.charAt(i);
            if(map1.containsKey(temp)){
                map1.replace(temp, map1.get(temp)+1);
            }
            map1.put(temp, 1);
        }
        for(int i = 0; i < s2.length(); i++){
            char temp = s2.charAt(i);
            if(map2.containsKey(temp)){
                map2.replace(temp, map2.get(temp)+1);
            }
            map2.put(temp, 1);
        }
        return map1.equals(map2);
    }


}
