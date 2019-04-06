import java.util.*;

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        this.val = x;
        this.next = null;
    }
}

public class ListNodeCross {

    //指针两遍遍历
    public static ListNode nodeCross(ListNode head1, ListNode head2){
        if(head1 == null || head2 == null){
            return null;
        }
        ListNode a = head1;
        ListNode b = head2;
        while(a != b){
            a = a == null ? head2 : a.next;
            b = b == null ? head1 : b.next;
        }
        return a;
    }

    //根据长度找
    public static ListNode nodeCross2(ListNode head1, ListNode head2){
        if(head1 == null || head2 == null){
            return null;
        }
        int len1 = 0;
        int len2 = 0;
        ListNode a = head1;
        ListNode b = head2;
        while(a != null){
            len1++;
            a = a.next;
        }
        while(b != null){
            len2++;
            b = b.next;
        }
        a = head1;
        b = head2;
        while(len1 != len2){
            if(len1 > len2){
                a  = a.next;
                len1 --;
            }else{
                b = b.next;
                len2 ++;
            }
        }
        while(a != b){
            a = a.next;
            b = b.next;
        }
        return a;
    }

    //使用栈从后往前找
    public static ListNode nodeCross3(ListNode head1, ListNode head2){
        if(head1 == null || head2 == null){
            return null;
        }
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        ListNode a = head1;
        ListNode b = head2;
        ListNode result = new ListNode(-1);

        while (a != null){
            stack1.push(a);
            a = a.next;
        }
        while(b != null){
            stack2.push(b);
            b = b.next;
        }

        while(stack1.peek() == stack2.peek()){
            result = stack1.pop();
            stack2.pop();
        }

        return result;
    }

    public static void main(String[] args){
        ListNode head1 = new ListNode(2);
        head1.next = new ListNode(3);
        head1.next.next = new ListNode(4);

        ListNode head2 = new ListNode(5);
        head2.next = head1.next.next;

        ListNode result = nodeCross3(head1, head2);
        System.out.println(result.val);
    }
}
