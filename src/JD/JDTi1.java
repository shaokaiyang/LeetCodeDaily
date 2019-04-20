/**
 * 问题：体育场突然着火了，现场需要紧急疏散，但是过道真的是太窄了，同时只能容许一个人通过。
 * 现在知道了体育场的所有座位分布，座位分布图是一棵树，已知每个座位上都坐了一个人，安全出口在树的根部，
 * 也就是1号结点的位置上。其他节点上的人每秒都能向树根部前进一个结点，但是除了安全出口以外，没有任何一个结点可以同时容纳两个及以上的人，
 * 这就需要一种策略，来使得人群尽快疏散，问在采取最优策略的情况下，体育场最快可以在多长时间内疏散完成。
 *
 * 解决方法：在根节点的所有子树中找一颗包含节点最多的子树，那么节点数就为最终的时间
 * 关键问题在于原始数据信息的存储方式，数据量为100000，二维矩阵需要10000000000；
 * 可以尝试不用二维数组存储用链表的方式进行存储；
 *
 * 时间复杂度：O（n*n）
 * 想到的边界测试用例：
 */

import java.util.*;

public class JDTi1 {

    static class Node{
        //记录节点ID
        int val;
        List<Integer> list;
        public Node(int i){
            this.val = i;
            list = new ArrayList<>();
        }
    }

    public static int getNodes(Node[] nodes, int cur, int last){
        List<Integer> list = nodes[cur].list;
        int count = list.size() - 1;
        for(int tmp : list){
            if(tmp == last){
                continue;
            }else{
                count += getNodes(nodes, tmp, nodes[cur].val);
            }
        }
        return count;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Node[] nodes = new Node[n+1];
        for(int i = 1; i <= n; i++){
            Node node = new Node(i);
            nodes[i] = node;
        }
        for(int i = 0; i < n-1; i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            nodes[a].list.add(b);
            nodes[b].list.add(a);
        }

        int max = 0;
        for(int item : nodes[1].list){
            int count = getNodes(nodes, item, 1);
            max = Math.max(count ,max);
        }

        System.out.println(max + 1);
    }
}
