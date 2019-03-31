import java.util.*;

public class BasicOperation {

    public static void main(String[] args){
        // hashmap
        Map<Character,Integer> map = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();
        map.put('a',11);
        map.put('b',2);
        map.put('c',6);
        map.put('a',map.get('a')+1);
        map2.putAll(map);
        map2.put('d',10);
        List<Map.Entry<Character,Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        System.out.println(list);
        /*
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getKey().compareTo(o1.getKey());
            }
        });
        */
        //map2.clear();
        /*
        System.out.println(map2);
        System.out.println(list);
        System.out.println(map.equals(map2));
        System.out.println(map.containsKey('a'));
        System.out.println(map.containsValue(2));
        System.out.println(map.entrySet());
        System.out.println(map.keySet());
        System.out.println(map.values());
        */

        //HashSet使用
        /*
        Set<String> set = new HashSet<>();
        set.add("sky");
        set.add("wxl");
        String[] listSet = new String[5];
        set.toArray(listSet);
        System.out.println(listSet[0]);
        System.out.println(set.contains("wxl"));
        System.out.println(set.size());
        */

        //stack
        /*
        Stack<String> stack = new Stack<>();
        stack.push("sky");
        stack.push("wxl");
        stack.pop();
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
        */

        //队列
        /*
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        queue.offer(2);
        ((ArrayDeque<Integer>) queue).offerFirst(5);
        System.out.println(queue.peek());
        queue.poll();
        System.out.println(queue);
        */

        //优先级队列,默认是小顶堆
        /*
        Queue<Integer> queue = new PriorityQueue<>();
        queue.offer(4);
        queue.offer(3);
        queue.offer(10);
        queue.offer(8);

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        };

        Queue<Integer> maxHeap = new PriorityQueue<>(comparator);
        maxHeap.addAll(queue);

        for(int i = 0; i < 4; i++){
            System.out.println(maxHeap.poll());
        }
        System.out.println(queue);
        */

        //list使用

        List<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(8);
        list2.add(6);
        list2.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;//-1表示不用调整，1表示要调整
            }
        });
        System.out.println(list2);

    }

}
