package linkedlist;

public class PalindromeList {
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public class Solution {

        private ListNode head;

        public int lPalin(ListNode A) {
            this.head = A;
            return lPalinRecursive(A);
        }

        public int lPalinRecursive(ListNode A) {
            if (A == null) return 1;
            int res = lPalinRecursive(A.next);
            if (res == 1) {
                if (head.val == A.val) {
                    head = head.next;
                    return 1;
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        }
    }
}
