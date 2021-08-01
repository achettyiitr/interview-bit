package linkedlist;

public class ReverseAlternateKNodes {
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public class Solution {
        public ListNode solve(ListNode A, int B) {
            return reverseKNodes(A, B, 0);
        }

        private ListNode reverseKNodes(ListNode A, int k, int level) {
            ListNode p = null, c = A, n = null;
            int count = k;
            while (count > 0 && c != null) {
                if (level % 2 == 0) {
                    n = c.next;
                    c.next = p;
                    p = c;
                    c = n;
                } else {
                    n = c.next;
                    p = c;
                    c = n;
                }
                count--;
            }
            if (level % 2 == 0) {
                if (n != null) {
                    A.next = reverseKNodes(n, k, level + 1);
                }
            } else {
                if (p != null) {
                    p.next = reverseKNodes(n, k, level + 1);
                }
            }

            return (level % 2 == 0) ? p : A;
        }
    }
}
