public class Solution2 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode res = new ListNode(0);//新建一个链表 存放结果
        if (l1 == null && l2 == null) {
            return null;
        }

        if (l1 == null) {
            l1 = new ListNode(0);
        }

        if (l2 == null) {
            l2 = new ListNode(0);
        }
        int res = l1.val + l2.val; //相加小于10的情况
        if ((res) >= 10) {
            res = res % 10;  //如果大于10，相当于可以直接给了l1的下一个元素增加了1，给l2也可以同理
            if (l1.next != null) {
                l1.next.val += 1;
            } else {
                l1.next = new ListNode(1);
            }
        }
        return new ListNode(res,addTwoNumbers(l1.next,l2.next));
    }
}
