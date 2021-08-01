package backtracking;

public class ReverseLinkListRecursion {
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
            if (A == null || A.next == null) return A;
            ListNode next = A.next;
            ListNode reverse = reverseList(A.next);
            next.next = A;
            A.next = null;
            return reverse;
        }
    }
}
