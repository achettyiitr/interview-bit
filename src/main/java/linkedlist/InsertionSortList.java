package linkedlist;

public class InsertionSortList {
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        public ListNode insertionSortList(ListNode A) {
            ListNode temp = A, root = new ListNode(-1);
            while (temp != null) {
                ListNode next = temp.next;
                temp.next = null;
                insertAsPerInsertionSortOrder(root, temp);
                temp = next;
            }
            return root.next;
        }

        private void insertAsPerInsertionSortOrder(ListNode root, ListNode node) {
            ListNode temp = root;
            while (temp.next != null && temp.next.val < node.val) {
                temp = temp.next;
            }
            if (temp.next == null) {
                temp.next = node;
                node.next = null;
            } else {
                ListNode tempNext = temp.next;
                temp.next = node;
                node.next = tempNext;
            }
        }
    }
}
