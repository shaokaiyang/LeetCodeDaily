import java.util.HashMap;
import java.util.HashSet;

/**
 * 面试宝典中链表相关的题目
 * sky
 */

class LinkedListNode{
    int val;
    LinkedListNode next;
    LinkedListNode(int val){
        this.val = val;
        next = null;
    }
}

public class LinkedList {

    /**
     * 问题：删除一个未排序链表中的重复节点
     * 方法：（1）使用hashset来检测节点是否重复；
     * time:o(n)
     * space:o(n)
     * （2）不使用额外的空间，对于每一个节点，遍历后续节点看是否存在重复，如果重复则删除
     * time:o(n^2)
     * space:o(1)
     */
    public static void deleteDups(LinkedListNode head){
        HashSet<Integer> hashSet = new HashSet<>();
        LinkedListNode pre = null;
        while(head != null){
            if(hashSet.contains(head.val)){
                pre.next = head.next;
            }else{
                hashSet.add(head.val);
                pre = head;
            }
            head = head.next;
        }
    }
    public static void deleteDups2(LinkedListNode head){
        LinkedListNode cur = head;
        while(cur != null){
            LinkedListNode runner = cur;
            while(runner.next != null){
                if(runner.next.val == cur.val){
                    runner.next = runner.next.next;
                }else{
                    runner = runner.next;
                }
            }
            cur = cur.next;
        }
    }

    






}
