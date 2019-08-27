import javax.print.DocFlavor;
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
    public static Map<Character, Integer> putIntoMap(String s){
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char temp = s.charAt(i);
            if(map.containsKey(temp)){
                map.replace(temp, map.get(temp)+1);
            }
            map.put(temp, 1);
        }
        return map;
    }
    public static boolean isSame1(String s1, String s2){
        return s1.length() == s2.length() && putIntoMap(s1).equals(putIntoMap(s2));
    }

    /**
     * 问题：将一个字符串中的空格替换为“%20”，假定字符串数组后面有足够的空间可以存放新增字符串，并且知道字符串的真实长度；
     * 思路：从后往前进行转换，这样不必担心会覆盖前面的数据
     * time:o(n)
     * space:o(1)
     */
    public static void replaceSpace(char[] str , int length){
        int cnt = 0; // recode the number of space;
        int len = 0; // recode the new array length;
        int i;
        for(i = 0 ; i < length; i++){
            if(str[i] == ' '){
                cnt ++;
            }
        }
        // calculate the new array length;
        len = length + cnt * 2;
        str[len] = '\0';
        // replace from the tail to head
        for(i = length-1; i >= 0; i-- ){
            if(str[i] == ' '){
                str[len - 1] = '0';
                str[len - 2] = '2';
                str[len - 3] = '%';
                len -= 3;
            }else{
                str[len-1] = str[i];
                len --;
            }
        }
    }

    /**
     * 1.5问题： 压缩字符串。例如 aabcccc 压缩后为a2b1c4如果压缩后字符串没有变短则返回原字符串
     * 思路：使用StringBuilder进行顺次处理
     * time:o(n)
     * space:o(n)
     */
    public static String compressBetter(String s){
        StringBuilder stringBuilder = new StringBuilder();
        char last = s.charAt(0); //recode the pre char
        int length = s.length();
        int count = 1;
        for(int i = 1; i < length; i++){
            if(s.charAt(i) == last){
                count ++;
            }else{
                stringBuilder.append(last);
                stringBuilder.append(count);
                last = s.charAt(i);
                count = 1;
            }
        }
        // solve the last char
        stringBuilder.append(last);
        stringBuilder.append(count);
        // judge the length
        // maybe you can judge the length in the start, but it will increase the complexity
        return stringBuilder.length() > length ? s : stringBuilder.toString();
    }

    /**
     * 1.6 问题：将一个N*N矩阵顺时针旋转90度（其他形如顺时针180度，或者逆时针90度都一样的思路），不占用额外空间
     * 思路：一层一层逐个进行旋转
     * time:o(n^2)
     * space:o(1)
     */
    public static void rotate(int[][] matrix, int n){
        for(int layer = 0; layer < n/2; layer++){
            int first = layer;
            int last = n - 1 - layer;
            for(int i = first; i < last; i++){
                int offset = i - first;
                // 存储左上边元素
                int top = matrix[first][i];
                // 左到上
                matrix[first][i] = matrix[last-offset][first];
                // 下到左
                matrix[last-offset][first] = matrix[last][last-offset];
                // 右到下
                matrix[last][last-offset] = matrix[i][last];
                // 上到右
                matrix[i][last] = top;
            }
        }
    }

    /**
     * 1.7问题：将一个M*N矩阵中0元素所在行和列清零
     * 思路：记录0元素所在行和列，然后清零
     * time：o(mn)
     * space:o(m+n)
     */
    public static void setZero(int[][] matrix){
        boolean[] row = new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length];
        // recode the row and column of 0
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j ++) {
                if(matrix[i][j] == 0){
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        // set 0
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(row[i] || col[j]){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * 1.8 问题：给定isSubstring方法（经典的KMP算法,下面仅给出最一般的实现方式，在另一篇中专门解读KMP），判断一个字符串是否由另一个字符串翻转得到，例如abc,cab
     * 思路：S2是否是S1旋转得到，如果是则需要保证S2是S1S1的子串
     * S1 = xy
     * S2 = yx
     * S1S1 = xyxy
     * S2是S1的子串
     */
    public static boolean isSubstring(String s1, String s2){
        // the index of s1
        int i = 0;
        // the index of s2
        int j = 0;
        while(i < s1.length() && j < s2.length()){
            if(s1.charAt(i) == s2.charAt(j)){
                i ++;
                j ++;
            }else{
                // Backtracking
                i = i - j + 1;
                j = 0;
            }
        }
        return j == s2.length();
    }

    public static boolean isRotation(String s1, String s2){
        return (s1.length() == s2.length() && s1.length() > 0 && isSubstring(s1 + s1, s2));
    }

    /**
     * KMP算法实现
     * 1. 先实现next数据生成
     * 2. 然后根据next数据进行匹配
     */
    public static int[] getNext(String s){
        int[] next = new int[s.length()];
        next[0] = -1;
        int j = 0;
        int k = -1;
        while(j < s.length() - 1){
            if(k == -1 || s.charAt(j) == s.charAt(k)){
                if(s.charAt(++j) == s.charAt(++k)){
                    next[j] = next[k];
                }else{
                    next[j] = k;
                }
            }else{
                k = next[k];
            }
        }
        return next;
    }
    // s1 is main string ,s2 is pattern string
    public static int KMP(String s1, String s2){
        // the index of s1
        int i = 0;
        // the index of s2
        int j = 0;
        int[] next = getNext(s2);
        while (i < s1.length() && j < s2.length()){
            if(j == -1 || s1.charAt(i) == s2.charAt(j)){
                i ++;
                j ++;
            }else{
                j = next[j];
            }
        }
        return j == s2.length() ? i - j : -1;
    }




}
