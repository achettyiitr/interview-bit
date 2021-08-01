package linkedlist;

public class ReorderList {
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public class Solution {
        public ListNode reorderList(ListNode A) {
            if (A == null || A.next == null) return A;
            ListNode middle = middle(A);
            ListNode middleNext = middle.next;
            middle.next = null;
            ListNode reversedNext = reverse(middleNext);
            return merge(A, reversedNext);
        }

        private ListNode reverse(ListNode node) {
            ListNode p = null, c = node, n = null;
            while (c != null) {
                n = c.next;
                c.next = p;
                p = c;
                c = n;
            }
            return p;
        }

        private ListNode middle(ListNode node) {
            if (node == null)
                return node;
            ListNode slow = node, fast = node;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        private ListNode merge(ListNode a, ListNode b) {
            if (a == null)
                return b;
            if (b == null)
                return a;
            ListNode anext = a.next;
            a.next = b;
            b.next = merge(anext, b.next);
            return a;
        }
    }
}
