import java.util.*;

public class JDT1 {

    //数组中寻找小于固定值的最大下标
    public static int minIndex(int[] a, int index, int value){
        int result = -1;
        if(index > a.length-1){
            return result;
        }
        for(int i = index; i < a.length; i++){
            if(a[i] < value){
                if(i > result){
                    result = i;
                }
            }
        }
        return result;
    }

    // 寻找max
    public static int findMax(int[] a, int left, int right){
        if(left > a.length-1 || right > a.length-1){
            return -1;
        }
        int max = a[left];
        for(int i = left; i <= right; i++){
            if(a[i] > max){
                max = a[i];
            }
        }
        return max;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] high = new int[n];
        for(int i = 0; i < n; i++){
            high[i] = in.nextInt();
        }

        int count = 0;
        for(int i = 0; i < n;){
            int max = high[i];
            int start = i;
            int minIndex = minIndex(high,i+1,high[i]);
            if(minIndex != -1){
                i = minIndex;
            }
            while(minIndex != -1){
                max = Math.max(findMax(high,start,minIndex), max);
                start = minIndex + 1;
                minIndex = minIndex(high,start,max);
                if(minIndex != -1){
                    i = minIndex;
                }
            }
            i ++;
            count ++;

        }
        System.out.println(count);



    }
}
