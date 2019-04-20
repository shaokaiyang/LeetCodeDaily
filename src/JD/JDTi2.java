/**
 * 问题：给出m个字符串S1，S2，...，Sm和一个单独的字符串T。请在T中选出尽可能多的子串同时满足：
 * 1）这些子串在T中互不相交。
 * 2）这些子串都是S1，S2，...，Sm中的某个串。
 * 问最多能选出多少个子串。
 *
 * 尝试解决方法：采用贪心的思路进行求解，每次从最短的串开始匹配
 * 时间复杂度：
 * 想到的边界测试用例：
 */


import java.util.*;

public class JDTi2 {

    static class Node{
        int start;
        int end;
        boolean use;
        Node(int start, int end){
            this.start = start;
            this.end = end;
            this.use = true;
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] strings = new String[n];
        for(int i = 0; i < n; i++){
            strings[i] = scanner.nextLine();
        }
        String s = scanner.nextLine();
        List<Node> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int index = s.indexOf(strings[i], 0);
            while(index != -1){
                list.add(new Node(index, index + strings[i].length()));
                index = s.indexOf(strings[i], index+1);
            }
        }
        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.end - o2.end;
            }
        });
        int nums = 0;
        for(int i = 0; i < list.size(); i++){
            if(!list.get(i).use){
                continue;
            }
            nums++;
            for(int j = i + 1; j < list.size(); j++){
                if(list.get(j).start < list.get(i).end){
                    list.get(j).use = false;
                }
            }
        }
        System.out.println(nums - 1);

    }

}
