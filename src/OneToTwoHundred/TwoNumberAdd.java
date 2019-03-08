
class TwoNumberAdd {

    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
            next = null;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode pHead = new ListNode(0);
        ListNode cur = pHead;//设计一个头指针方便回找
        //存在进位问题
        int carry = 0;
        while(p1 != null || p2 != null){
            int x = (p1 != null) ? p1.val : 0;//两个数字的长度可能不一样，所以需要先判断，短的补0
            int y = (p2 != null) ? p2.val : 0;
            int sum = carry + x + y;
            carry = sum/10;
            cur.next = new ListNode(sum%10);//考虑进位
            cur = cur.next; //移动结果指针
            //判断是否还有节点，移动加数指针，注意不能用p1.next != null判断，会无限循环；
            if(p1 != null){
                p1 = p1.next;
            }
            if(p2 != null){
                p2 = p2.next;
            }
        }
        if(carry > 0){
            cur.next = new ListNode(carry);
        }
        return pHead.next;
    }
}