package linkedlist;

public class ListCycle {
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public class Solution {
        public ListNode detectCycle(ListNode a) {
            if (a == null || a.next == null) {
                return null;
            }
            if (a.next == a) {
                return a;
            }
            ListNode loopedNode = loopedNode(a);
            if (loopedNode == null) {
                return null;
            }

            ListNode start = a, end = loopedNode;
            while (start != end) {
                start = start.next;
                end = end.next;
            }
            return start;
        }

        private ListNode loopedNode(ListNode a) {
            ListNode slow = a, fast = a;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (slow == fast) return slow;
            }
            return null;
        }
    }
}
