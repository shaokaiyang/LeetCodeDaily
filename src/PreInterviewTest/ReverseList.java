
import java.util.*;


public class ReverseList {

    public static ListNode reverseList1(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode pre = new ListNode(-1);
        ListNode cur = head.next;
        pre = head;
        ListNode tmp = new ListNode(-1);
        while(cur != null){
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    public static ListNode reverseList2(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode result = new ListNode(-1);
        result = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return result;
    }

    public static ListNode reverseKNode(ListNode head ,int k){
        if(head == null || head.next == null){
            return head;
        }
        int count = 0;
        ListNode cur = head;
        while(cur != null && count != k){
            cur = cur.next;
            count ++;
        }
        if(count == k){
            cur = reverseKNode(cur, k);
            while(count -- > 0){
                ListNode tmp = head.next;
                head.next = cur;
                cur = head;
                head = tmp;
            }
            head = cur;
        }
        return head;
    }

    public static void main(String[] args){
         ListNode head = new ListNode(1);
         ListNode cur = head;
         for(int i = 2; i < 7; i++){
             cur.next = new ListNode(i);
             cur = cur.next;
         }
         ListNode result = new ListNode(-1);
         result = reverseKNode(head, 3) ;
         System.out.println(result.next.val);
    }
}
