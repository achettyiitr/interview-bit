package linkedlist;

public class SortBinaryLinkedList {
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
            ListNode oneH = new ListNode(-1);
            ListNode twoH = new ListNode(-1);
            ListNode oneT = oneH, twoT = twoH;
            ListNode temp = A;
            while (temp != null) {
                ListNode next = temp.next;
                if (temp.val == 0) {
                    oneT.next = temp;
                    oneT = oneT.next;
                } else {
                    twoT.next = temp;
                    twoT = twoT.next;
                }
                temp = next;
            }
            oneT.next = twoH.next;
            twoT.next = null;
            return oneH.next;
        }
    }

}
