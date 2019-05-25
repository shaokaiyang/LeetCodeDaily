import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 相关链表操作的题目
 * @author sky
 * @date 2019/5/1
 */

public class ListOperation {
    static class Node{
        int val;
        Node next;
        Node(int i){
            this.val = i;
            this.next = null;
        }
    }

    /**
     * Author: UpToSky
     * 题目： 206 链表反转
     * 实现分析：额外定义三个节点，以头插法的方式进行链表建立
     * cur： 进行实际操作的节点，这里主要是想留一个头指针；
     * pre： 用于存储反转链表的头指针
     * tmp: 暂存未反转部分的头指针
     * time: O(n)
     * space: O(1)
     * @param head：头指针
     * @return
     */
    public static Node reverseList(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node cur = head.next;
        Node pre = head;
        pre.next = null;
        Node tmp ;
        while(cur != null){
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    /**
     * Author： UpToSky
     * 题目： 24：链表两两反转；25：K个一组反转，这两个题目其实是一个题目，
     * 实现了K个一组反转，任意数对的反转都可以直接使用
     * 实现思路：递归实现，先找到前K个节点，对这K个节点利用链表反转的思想反转，
     * 剩余的节点递归进行
     * time：O(n)
     * space:O(1)
     * @param head：头指针
     * @param k：需要进行翻转的组数
     * @return
     */
    public static Node reverseKList(Node head, int k){
        if(head == null || head .next == null){
            return head;
        }
        //不直接对head操作，这样可以保留一个头指针
        Node cur = head;
        // 记录节点个数
        int count = 0;
        // 找到需要进行翻转的K个节点
        while(cur != null && count != k){
            cur = cur.next;
            count ++;
        }
        // 进行特殊情况处理
        if(count == k){
            cur = reverseKList(cur, k);
            while(count -- > 0){
                Node tmp = head.next;
                // 与后面翻转好的连接
                head.next = cur;
                cur = head;
                head = tmp ;
            }
            head = cur;
        }
        return head;
    }

    /**
     * Author: UpToSky
     * 题目：141，判断链表是否有环
     * 实现：使用快慢指针，快指针每次走两步，慢指针每次走一步
     * time: O(n)
     * space：0(1)
     * @param head：头指针
     * @return
     */
    public static boolean isCircleByFastSlow(Node head){
        if(head == null || head.next == null){
            return false;
        }
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }

    /**
     * Author: UpToSky
     * 题目：141，判断链表是否有环
     * 实现：使用set集合进行
     * time: O(n)
     * space：0(1)
     * @param head：头指针
     * @return
     */
    public static boolean isCircleBySet(Node head){
        if(head == null || head.next == null){
            return false;
        }
        Set<Node> set = new HashSet<>();
        Node cur = head;
        while(cur != null){
            // 如果set中不包含当前节点则加入
            // 否则直接返回true
            if(!set.contains(cur)){
                set.add(cur);
                cur = cur.next;
            }else{
                return true;
            }
        }
        return false;
    }

    /**
     * 当前节点走K步之后是否为空
     * @param head：头结点
     * @param k：K处
     * @return
     */
    public static boolean isNull(Node head, int k){
        if(head == null){
            return true;
        }
        Node cur = head;
        while(k -- > 0){
            if(cur.next != null){
                cur = cur.next;
            }else{
                return true;
            }
        }
        return false;
    }
    /**
     * 返回1/k处的节点，例如中间节点为1/2处节点
     * @param head：头结点
     * @param k：K处
     * @return
     */
    public static Node getNodeOfK(Node head, int k){
        if(head == null){
            return null;
        }
        Node fast = head;
        Node slow = head;
        while(!isNull(fast, k)){
            int count = k;
            while(count -- > 0){
                fast = fast.next;
            }
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 两边扫描求链表的交,此处保证链表有交
     * 可以提前判断链表是否有交，判断链表有交的方法很多
     * @param head1：头指针
     * @param head2：头指针
     * @return
     */
    public static Node mixedListByFastSlow(Node head1, Node head2){
        if(head1 == null || head2 == null){
            return null;
        }
        Node p1 = head1;
        Node p2 = head2;
        while(p1 != p2){
            p1 = p1 == null ? head2 : p1.next;
            p2 = p2 == null ? head1 : p2.next;
        }
        return p1;
    }

    /**
     * 使用栈求交
     * @param head1
     * @param head2
     * @return
     */
    public static Node mixedListByStack(Node head1, Node head2){
        if(head1 == null || head2 == null){
            return null;
        }
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        Node result = new Node(0);
        while(head1 != null){
            stack1.push(head1);
            head1 = head1.next;
        }
        while(head2 != null){
            stack2.push(head2);
            head2 = head2.next;
        }
        if(stack1.peek() != stack2.peek()){
            return null;
        }else{
            while(stack1.peek() == stack2.peek()){
                result = stack1.pop();
                stack2.pop();
            }
        }
        return result;
    }

    /**
     * 使用set集合判断链表的交
     * @param head1
     * @param head2
     * @return
     */
    public static Node mixedListBySet(Node head1, Node head2){
        if(head1 == null || head2 == null){
            return null;
        }
        Set<Node> set = new HashSet<>();
        while(head1 != null){
            set.add(head1);
            head1 = head1.next;
        }
        while(head2 != null){
            if(set.contains(head2)){
                return head2;
            }else{
                head2 = head2.next;
            }
        }
        return null;
    }

    /**
     * 将链表向右移动K个位置
     * @param head：头结点
     * @param k：位置
     * @return
     */
    public static Node rotateList(Node head, int k){
        if(head == null){
            return null;
        }
        Node cur = head;
        int count = 0;
        while(cur != null){
            count ++;
            cur = cur.next;
        }
        k %= count;
        // 指向后面部分
        Node fast = head;
        while(k -- > 0){
            fast = fast.next;
        }
        // 指向前面部分
        Node slow = head;
        // 这个地方要想明白，两个指针同时向前走
        // 最终可以走到分界点
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        Node newHead = slow.next;
        fast.next = head;
        slow.next = null;
        return newHead;
    }


}
