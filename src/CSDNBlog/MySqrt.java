/**
 * 自己实现开方运算
 * 思路：二分查找和牛顿迭代法或调用其他一些库
 * @author sky
 * @date 2019/4/29
 */

import javax.net.ssl.SSLContext;
import java.util.*;


public class MySqrt {
    public static final double epr = 1e-10;

    public static double sqrtByNewton(double n){
        double result = 1;
        while(Math.abs(result * result - n) > epr){
            //根据迭代公式直接进行计算
            result = (n / result + result) / 2;
        }
        return result;
    }

    public static double sqrtByDo(double n){
        double left = 0;
        double right = n;
        //保存上一次计算结果
        double last ;
        // 这种写法可以防止数据溢出
        double mid = left + (right - left) / 2;
        do{
            // 如果所求的值较大更新右边界
            //否则更新左边界
            if(mid > n / mid){
                right = mid;
            }else{
                left = mid;
            }
            last = mid;
            mid = left + (right - left) / 2;
        }while(Math.abs(last - mid) > epr);
        return mid;
    }

    public static double sqrtByWhile(double n){
        double left = 0;
        double right = n;
        double mid = left + (right - left) / 2;
        while (Math.abs(n - mid * mid) > epr){
            if(n / mid > mid){
                left = mid;
            }else{
                right = mid;
            }
            mid = left + (right - left) / 2;
        }
        return mid;
    }

    public static void main(String[] args){
        double n = 2.0;
        Formatter formatter = new Formatter(System.out);
        formatter.format("result is %.10f\n", sqrtByDo(n));
        formatter.close();
        System.out.println(sqrtByNewton(n));
        System.out.println(sqrtByDo(n));
        System.out.println(sqrtByWhile(n));
    }
}
