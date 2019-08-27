
import java.util.*;

/**
 * 给定一个数据表明选择不同角色的人数，每三个人可以组成一个小组，求可以组成的最大组数；
 *
 * 方法：每次排序找前三大数进行分组，然后再分组，直到第三大数为0为止
 */
public class yuanfudao1 {
    public static void main(String[] args){
        int len = 100000;
        int[] a = new int[len];
        for(int i = 0; i < len; i++){
            a[i] = i;
        }
        int sum = 0;
        while (a[len-3] > 0){
            sum += a[len-3];
            a[len-1] -= a[len-3];
            a[len-2] -= a[len-3];
            a[len-3] = 0;
            Arrays.sort(a);
        }
        System.out.println(sum);
    }
}
