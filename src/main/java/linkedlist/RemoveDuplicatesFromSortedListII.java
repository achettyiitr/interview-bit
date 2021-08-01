package linkedlist;

public class RemoveDuplicatesFromSortedListII {
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public class Solution {
        public ListNode deleteDuplicates(ListNode A) {
            if (A == null || A.next == null) return A;
            ListNode result = new ListNode(Integer.MIN_VALUE);
            result.next = A;
            ListNode temp = result;
            while (A.next != null) {
                if (A.val == A.next.val) {
                    ListNode tt = A;
                    while(tt != null && tt.val == A.val) tt = tt.next;
                    temp.next = tt;
                    A = tt;
                    if (A == null) break;
                } else {
                    temp.next = A;
                    A = A.next;
                    temp = temp.next;
                }
            }
            return result.next;
        }
    }
}
