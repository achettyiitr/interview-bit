package linkedlist;

public class RemoveNthNodeFromListEnd {
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public class Solution {
        public ListNode removeNthFromEnd(ListNode A, int B) {
            int count = B;
            ListNode slow = A, fast = A;
            while (count > 0 && fast != null) {
                count--;
                fast = fast.next;
            }
            if (fast == null) {
                return A.next;
            } else {
                while (fast.next != null) {
                    fast = fast.next;
                    slow = slow.next;
                }
                slow.next = slow.next.next;
                return A;
            }
        }
    }
}
