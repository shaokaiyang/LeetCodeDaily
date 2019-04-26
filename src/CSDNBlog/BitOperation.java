import java.util.List;
import java.util.*;

/**
 * 位运算操作的一些总结
 * 包括一些经典的面试题目
 */

public class BitOperation {
    // 记录合格的N皇后情况数
   static int count = 0;
    // 记录皇后个数
    static int NQUEEN;
    static int a = 3;
    static int b = 4;

    // 求一个数中1的个数
    public static int numberOfOne1(int n){
        // 此方法会改变输入数据的值
        int cnt = 0;
        while(n != 0){
            cnt++;
            //去掉最后一个1
            n &= n-1;
        }
        return cnt;
    }

    //求一个数中1的个数
    public static int numberOfOne2(int n){
        // 此方法不会改变输入数据值
        int cnt = 0;
        int mask = 1;
        while(mask != 0){
            if((n & mask) != 0){
                cnt ++;
            }
            mask <<= 1;
        }
        return cnt;
    }

    //判断一个数是否是2的幂
    public static boolean isPowOfTwo(int n){
        return (n != 0 && (n & (n - 1)) == 0);
    }

    //判断一个数是否是4的幂
    public static boolean isPowOfFour(int n){
        //先判断是否是2的幂
        //然后判断1所在的位置是否在偶数位上
        return ((n & (n - 1)) == 0) && n >0 && ((n & 0x55555555) != 0);
        //数学理论如下
        //依据 #1: (4^n-1) = (4-1) (4^(n-1) + 4^(n-2) + 4^(n-3) + ….. + 4 + 1)
        //依据 #2 4^(n+1) - 1 = 4*4^n -1 = 3*4^n + 4^n-1
        // return n > 0 && (n & (n - 1)) == 0) && ((n - 1) % 3 == 0);
    }

    //位运算实现两数交换，在不使用中间变量前提下
    public static void change(int a , int b){
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        // 使用加法实现
//        a = a + b;
//        b = a - b;
//        a = a - b;
    }

    // 寻找一个数组中仅出现一次的数，这个数只有一个
    public static int findOnceAppearNumber(int[] nums, int len){
        int result = nums[0];
        for(int i = 1; i < len; i++){
            result ^= nums[i];
        }
        return result;
    }

    // 寻找一个数组中仅出现一次的数，这个数有两个
    public static int[] findOnceAppearNumber2(int[] nums, int len){
        int[] result = new int[2];
        int tmp = nums[0];
        for(int i = 1; i < len; i++){
            tmp ^= nums[i];
        }
        // 得到最后一位的1,并基于此将数组分为两部分
        int bits = tmp & (- tmp);
        List<Integer> arrays1 = new ArrayList<>();
        List<Integer> arrays2 = new ArrayList<>();
        for(int i = 0; i < len; i++){
            if((nums[i] & bits) == 0){
                arrays1.add(nums[i]);
            }else{
                arrays2.add(nums[i]);
            }
        }
        // 分别在两个数组中寻找出现一次的数
        // 此处可以直接调用出现一次的函数
        tmp = arrays1.get(0);
        for(int i = 1; i < arrays1.size(); i++){
            tmp ^= arrays1.get(i);
        }
        result[0] = tmp;
        // result[0] = findOnceAppearNumber(arrays1, array1.size());

        tmp = arrays2.get(0);
        for(int i = 1; i < arrays2.size(); i++){
            tmp ^= arrays2.get(i);
        }
        result[1] = tmp;
        // result[1] = findOnceAppearNumber(arrays2, array2.size());

        return result;
    }

    // 使用运运算实现加法
    public static int addByBit(int x, int y){
//        // 递归实现
//        if(y == 0){
//            return x;
//        }
//        // 进行不进位加法
//        int sum = x ^ y;
//        // 求进位
//        int carry = (x & y) << 1;
//        // 进位与不进位结果相加
//        return addByBit(sum, carry);
        // 迭代实现
        int sum = x ^ y;
        int carry = (x & y) << 1;
        while(carry != 0) {
            int a = sum;
            int b = carry;
            sum = a ^ b;
            carry = (a & b) << 1;
        }
        return sum;
    }

    // x:减数；y:被减数
    public static int substractByBit(int x, int y){
        // 先求减数的补码（除符号位外取反加1）
        int sub = addByBit(~y, 1);
        // 调用上面加法运算
        return addByBit(x, sub);
    }

    // 给定两个整数，求改变多少位可以使得两个数相同
    public static int changeCount(int n, int m){
        int cnt = 0;
        int tmp = n ^ m;
        while(tmp != 0){
            cnt ++;
            tmp &= (tmp - 1);
        }
        return cnt;
    }

    // 计算0，n上各个数的二进制表示中1的个数
    public static int[] findArrayNumberOfOne(int n){
//        //直接遍历的方式
//        int[] result = new int[n+1];
//        for(int i = 0; i <= n; i++){
//            result[i] = numberOfOne1(i);
//        }
        // 优化方式
        int[] result = new int[n+1];
        // 初始化第一个数
        result[0] = 0;
        for(int i = 1; i <= n; i++){
            result[i] = result[i & (i-1)] + 1;
        }
        return result;
    }

    public static void main(String[] args){
        int n = 4;
        int[] test = {1,4,1,2,4,3};
        int[] result = findOnceAppearNumber2(test,6);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

}
