/**
 * @author sky
 * @date 2019/03/05
 * description:小Q的父母要出差N天，走之前给小Q留下了M块巧克力。小Q决定每天吃的巧克力数量不少于前一天吃的一半，
 * 但是他又不想在父母回来之前的某一天没有巧克力吃，请问他第一天最多能吃多少块巧克力
 * intput:每个输入包含一个测试用例。
 * 每个测试用例的第一行包含两个正整数，表示父母出差的天数N(N<=50000)和巧克力的数量M(N<=M<=100000)。
 * output:输出一个数表示小Q第一天最多能吃多少块巧克力。
 * solution:对第一天可能吃的数量进行二分查找遍历，计算总数时取前一天的一半并向上取整。
 */

import java.util.Scanner;
public class GreedyLittleQ {

    // num 表示第一天最多吃num个巧克力一共需要的总数
    public static int sumChocolate(int day, int num){
        int total = 0;
        for(int i = 1; i < day; i++){
            total += num;
            num = (num+1)/2;
            //num = (int)Math.ceil((double)num/2);
        }
        return total;
    }

    public static int seaarchMaxChocolate(int day, int num){
        int first = 1;
        int last = num;
        int middle = (first + last) / 2;
        int sum = 0;
        if(day == num){
            return 1;
        }
        while(first <= last){
            sum = sumChocolate(day,middle);
            if(sum == num){
                return middle;
            }else if(sum < num){
                first = middle + 1;
            }else{
                last = middle -1;
            }
            middle = (first + last)/2;
        }
        return middle;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        System.out.println(seaarchMaxChocolate(N,M));
    }
}
