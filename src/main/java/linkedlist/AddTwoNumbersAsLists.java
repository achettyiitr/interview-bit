package linkedlist;

public class AddTwoNumbersAsLists {
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        public ListNode addTwoNumbers(ListNode A, ListNode B) {
            ListNode result = new ListNode(-1), temp = result;
            int c = 0;
            while (A != null || B != null) {
                int x = (A != null) ? A.val : 0;
                int y = (B != null) ? B.val : 0;
                int s = x + y + c;

                c = s / 10;
                s = s % 10;
                temp.next = new ListNode(s);
                temp = temp.next;
                if (A != null) A = A.next;
                if (B != null) B = B.next;
            }
            if (c != 0) temp.next = new ListNode(c);
            return result.next;
        }
    }
}
