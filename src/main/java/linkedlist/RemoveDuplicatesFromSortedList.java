package linkedlist;

public class RemoveDuplicatesFromSortedList {
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
            ListNode temp = A;
            while (temp != null) {
                if (temp.next != null && temp.next.val == temp.val) {
                    temp.next = temp.next.next;
                } else {
                    temp = temp.next;
                }
            }
            return A;
        }
    }
}
