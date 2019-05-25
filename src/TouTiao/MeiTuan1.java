/**
 * 思路：对于每个黑色节点进行遍历，如果与其直接连接的白色节点数目大于2
 * 则求其组合数并累积；
 */

import java.util.*;

public class MeiTuan1 {
     static final int MODEL = 1000000007;
     static final int NUMBER = 1000;

    // static int[][] CombinationNumber = new int[NUMBER][NUMBER];

    public static class Node{
        int id;
        int color;
        List<Integer> list;
        Node(int i){
            this.id = i;
            this.color = 0;
            list = new ArrayList<>();
        }
    }

    public static void main(String[] args){

//        //求解所有的组合数
//        for(int i = 0; i < NUMBER; i++){
//            //对角线上的元素为1
//            CombinationNumber[i][i] = 1;
//            //取0个元素的个数为1
//            CombinationNumber[i][0] = 1;
//        }
//        for(int i = 1; i < NUMBER; i++){
//            for(int j = 1; j < i; j++){
//                long tmp = CombinationNumber[i-1][j-1] + CombinationNumber[i-1][j];
//                CombinationNumber[i][j] = (int)(tmp % MODEL);
//            }
//        }

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Node[] nodes = new Node[n];
        for(int i = 0; i < n; i++){
            nodes[i] = new Node(i);
        }
        for(int i = 1; i < n; i++){
            int input = scanner.nextInt();
            nodes[i].list.add(input);
            nodes[input].list.add(i);
        }
        for(int i = 0; i < n; i++){
            nodes[i].color = scanner.nextInt();
        }
        long result = 1;
        for(int i = 0; i < n; i++){
            if(nodes[i].color == 1){
                int len = nodes[i].list.size();
                // 记录白节点个数
                int count = 0;
                List<Integer> arrays = nodes[i].list;
                for(int j = 0; j < len; j++){
                    int tmp = arrays.get(j);
                    if(nodes[tmp].color == 0){
                        count ++;
                    }
                }
                if(count >= 2){
                    long tmp1 = (result * count) % MODEL;
                    result = (int)tmp1;
                }

            }

        }
        System.out.println(result);
    }



}
