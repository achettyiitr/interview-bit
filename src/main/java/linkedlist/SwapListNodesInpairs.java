package linkedlist;

public class SwapListNodesInpairs {
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        public ListNode swapPairs(ListNode A) {
            return reverseList(A, 2);
        }

        public ListNode reverseList(ListNode A, int B) {
            int count = B;
            ListNode p = null, c = A, n = null;
            while (count > 0 && c != null) {
                count--;
                n = c.next;
                c.next = p;
                p = c;
                c = n;
            }
            if (n != null) {
                A.next = reverseList(n, B);
            }
            return p;
        }
    }
}
