package linkedlist;

public class SortList {
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public class Solution {
        public ListNode sortList(ListNode A) {
            if (A == null || A.next == null) return A;
            ListNode m = middle(A);
            ListNode mn = m.next;
            m.next = null;
            return merge(sortList(A), sortList(mn));
        }

        private ListNode middle(ListNode node) {
            if (node == null) return node;
            ListNode slow = node, fast = node;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        private ListNode merge(ListNode a, ListNode b) {
            if (a == null) return b;
            if (b == null) return a;
            if (a.val < b.val) {
                a.next = merge(a.next, b);
                return a;
            } else {
                b.next = merge(a, b.next);
                return b;
            }
        }
    }
}
