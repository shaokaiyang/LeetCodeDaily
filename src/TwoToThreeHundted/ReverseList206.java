import java.util.List;

public class ReverseList206 {

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    public static ListNode reverseList(ListNode head) {
            if(head == null){
                return head;
            }
            ListNode prev = head;
            head = head.next;
            prev.next = null;
            while(head != null){

                ListNode tmp = head.next;
                head.next = prev;
                prev = head;
                head = tmp;
                /*
                // 注意在进行链表赋值运算时，等号左右两边指向同一个内存区域
                ListNode tmp = head;
                tmp.next = prev;//因此该步操作之后改变了head中的值
                prev = tmp;
                head = head.next;
                */

            }
            return prev;
        }

        public static ListNode reverseList2(ListNode head){
            if(head == null || head.next == null){
                return head;
            }
            ListNode tmp = head.next; //将被调用的下一个节点分离
            ListNode reverseHead = reverseList2(tmp);//调用完成之后，tmp为完成翻转后的最后一个节点
            tmp.next = head;
            head.next = null;
                    return reverseHead;

        }

        public static void main(String[] args){
        ListNode p = new ListNode(1);
        p.next = new ListNode(2);
        p.next.next = new ListNode(3);

        ListNode result = reverseList2(p);
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }

        }

}
