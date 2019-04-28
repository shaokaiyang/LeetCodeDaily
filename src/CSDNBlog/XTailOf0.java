/**
 * 求x！末尾的0的个数
 * @author sky
 * @date 2019/4/28
 * 思路：2和5结合可以产生一个0，所以相当于求1——x的序列中包含
 * （2,5）的对数，因为2的个数多于5，所以相当于求因子中5的个数
 */

public class XTailOf0 {
    //寻找一个数包含因子5的个数
    public static int factorOf5(int n){
        int count = 0;
        while(n % 5 == 0){
            count ++;
            n /= 5;
        }
        return count;
    }
    //暴力法求每个数的因子包含5的个数
    public static int TailOf0ByForce(int n){
        int count = 0;
        if(n < 5){
            return 0;
        }
        //包含因子5的数只跟5的倍数的数相关
        for(int i = 5; i <= n; i += 5){
            count += factorOf5(i);
        }
        return count;
    }

    // 有几个5的倍数，有几个25的倍数，125的倍数……
    public static int TailOf0ByIter(int n){
        int count = 0;
        if(n < 5){
            return 0;
        }
        for(int i = 5; n / i > 0; i *= 5){
            count += n / i;
        }
        return count;
    }

    //循环方式进行求解
    public static int TailOf0While(int n){
        int count = 0;
        if(n < 5){
            return 0;
        }
        while(n >= 5){
            n /= 5;
            count += n;

        }
        return count;
    }

    //for循环方式
    public static int TailOf0For(int n){
        int count = 0;
        if(n < 5){
            return 0;
        }
        for(; n > 0; n /= 5){
            count += n / 5;
        }
        return count;
    }

    public static void main(String[] args){
        int n = 16;
        System.out.println(TailOf0ByForce(n));
        System.out.println(TailOf0ByIter(n));
        System.out.println(TailOf0While(n));
        System.out.println(TailOf0For(n));
    }
}
