
import java.util.*;

public class HasCycle{

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public boolean hasCycle(ListNode head) {
        Set<ListNode> node = new HashSet<>();
        while(head != null){
            if(node.contains(head)){
                return true;
            }else{
                node.add(head);
                head = head.next;
            }
        }
        return false;

    }

    public boolean hasCycle2(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}
