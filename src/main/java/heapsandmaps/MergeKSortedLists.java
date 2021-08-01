package heapsandmaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public class Solution {
        public ListNode mergeKLists(ArrayList<ListNode> A) {
            PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
                @Override
                public int compare(ListNode a, ListNode b) {
                    return Integer.compare(a.val, b.val);
                }
            });
            for (int i = 0; i < A.size(); i++) {
                ListNode node = A.get(i);
                if (node != null) {
                    pq.add(node);
                }
            }
            ListNode result = new ListNode(-1);
            ListNode temp = result;
            while (!pq.isEmpty()) {
                ListNode dnode = pq.remove();
                temp.next = dnode;
                temp = temp.next;
                if (dnode.next != null) {
                    dnode = dnode.next;
                    pq.add(dnode);
                }
            }
            return result.next;
        }
    }
}
