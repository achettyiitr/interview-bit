package linkedlist;

public class PartitionList {
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public class Solution {
        public ListNode partition(ListNode A, int B) {
            ListNode l = new ListNode(-1), m = new ListNode(-1);
            ListNode lt = l, mt = m;
            ListNode t = A;
            while (t != null) {
                ListNode n = t.next;
                if (t.val < B) {
                    lt.next = t;
                    lt = lt.next;
                } else {
                    mt.next = t;
                    mt = mt.next;
                }
                t = n;
            }
            mt.next = null;
            lt.next = m.next;
            return l.next;
        }
    }
}
