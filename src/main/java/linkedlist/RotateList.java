package linkedlist;

public class RotateList {
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public class Solution {
        public ListNode rotateRight(ListNode A, int B) {
            if (A == null || B == 0) return A;
            ListNode temp = A;
            int length = 1;
            while (temp.next != null) {
                temp = temp.next;
                length++;
            }
            temp.next = A;
            B = B % length;
            int moves = length - B;
            while (moves > 0) {
                temp = temp.next;
                moves--;
            }
            ListNode newHead = temp.next;
            temp.next = null;
            return newHead;
        }
    }
}
