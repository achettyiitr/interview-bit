package linkedlist;

public class ReverseLinkedList {
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public class Solution {
        public ListNode reverseList(ListNode A) {
            ListNode p = null, c = A, n = null;
            while (c != null) {
                n = c.next;
                c.next = p;
                p = c;
                c = n;
            }
            return p;
        }
    }
}
