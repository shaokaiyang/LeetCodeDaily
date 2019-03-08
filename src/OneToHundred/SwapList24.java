


class SwapList24 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode root = new ListNode(0); //定义一个头指针
        root.next = head;
        ListNode pre = root; //记录上次交换完的位置

        while(pre.next != null && pre.next.next != null){
            ListNode start = pre.next;
            ListNode end = pre.next.next;
//1 2 3 4 5 如果要交换 3 4 ，需要2指向4,3指向5,4指向3；
            pre.next = end;
            start.next = end.next;
            end.next = start;

            pre = start;//更新位置
        }
        return root.next;

    }
}
