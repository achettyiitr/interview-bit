package linkedlist;

public class ReverseLinkListII {
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public class Solution {
        public ListNode reverseBetween(ListNode A, int B, int C) {
            if (A == null) return A;
            if (B >= C) return A;
            int count1 = B, count2 = C;
            ListNode temp = A, previousStart = null, start = null, end = null, endNext = null;

            while (count1 > 1 && temp != null) {
                previousStart = temp;
                temp = temp.next;
                count1--;
            }
            if (count1 > 1) return A;
            start = temp;

            temp = A;
            while (count2 > 1 && temp != null) {
                temp = temp.next;
                count2--;
            }
            if (count2 > 1) return A;
            end = temp;
            endNext = end.next;
            end.next = null;

            // System.out.println("Previous: " + start.val);
            // System.out.println("End: " + end.val);
            ListNode revsersedStart = reverse(start);
            start.next = endNext;
            if (previousStart != null) {
                previousStart.next = revsersedStart;
                return A;
            } else {
                return revsersedStart;
            }
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
    }
}
