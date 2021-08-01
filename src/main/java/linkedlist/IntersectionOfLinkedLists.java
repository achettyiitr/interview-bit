package linkedlist;

public class IntersectionOfLinkedLists {
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public class Solution {
        public ListNode getIntersectionNode(ListNode a, ListNode b) {
            if (a == null || b == null) return null;
            ListNode a1 = a, b1 = b;
            while (a1 != b1) {
                if (a1 == null) a1 = b;
                if (b1 == null) b1 = a;
                if (a1 == b1) break;
                a1 = a1.next;
                b1 = b1.next;
            }
            return a1;
        }
    }
}
