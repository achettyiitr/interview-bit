package linkedlist;

public class KthNodeFromMiddle {
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public class Solution {
        public int solve(ListNode A, int B) {
            ListNode node = solveHelper(A, B);
            if (node == null) return -1;
            else return node.val;
        }

        public ListNode solveHelper(ListNode A, int B) {
            ListNode mn = middleNode(A);
            ListNode kthNode = kthNode(A, mn, B);
            return kthNode;
        }

        private ListNode middleNode(ListNode root) {
            if (root == null || root.next == null) return root;
            ListNode slow = root, fast = root;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        private ListNode kthNode(ListNode start, ListNode end, int k) {
            if (end == null || k == 0) return end;
            ListNode slow = start, fast = start;
            int count = k;
            while (count > 0 && fast != end) {
                count--;
                fast = fast.next;
            }
            if (count > 0) return null;
            while(fast != end) {
                fast = fast.next;
                slow = slow.next;
            }
            return slow;
        }
    }
}
