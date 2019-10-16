package offer;

import java.util.ArrayList;

public class printListFromTailToHead {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    public class Solution {
        public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
            ArrayList<Integer> arr = new ArrayList<Integer>();
            ListNode reverse = listRverse(listNode);
            ListNode cur = reverse;
            while (cur != null) {
                arr.add(cur.val);
                cur = cur.next;
            }
            listRverse(listNode);
            return arr;
        }

        public ListNode listRverse(ListNode listNode) {
            ListNode pre = null;
            ListNode cur = listNode;
            ListNode tmp = null;

            while (cur != null) {
                tmp = cur;
                cur = cur.next;
                tmp.next = pre;
                pre = tmp;
            }
            return pre;
        }
    }
}
