package linkedlist;

public class EvenReverse {
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public class Solution {
        public ListNode solve(ListNode A) {
            ListNode eH = null, oH = null, o = null;
            int count = 1;
            while (A != null) {
                ListNode n = A.next;
                if (count % 2 == 0) {
                    A.next = eH;
                    eH = A;
                } else {
                    if (oH == null) {
                        oH = A;
                        o = oH;
                    } else {
                        o.next = A;
                        o = o.next;
                    }
                }
                count++;
                A = n;
            }
            o.next = null;
            return merge(oH, eH);
        }

        private ListNode merge(ListNode a, ListNode b) {
            if (a == null) return b;
            if (b == null) return a;
            ListNode anext = a.next;
            a.next = b;
            b.next = merge(anext, b.next);
            return a;
        }
    }
}
