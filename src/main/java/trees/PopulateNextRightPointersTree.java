package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PopulateNextRightPointersTree {
    class TreeLinkNode {
        int val;
        TreeLinkNode left;
        TreeLinkNode right;
        TreeLinkNode next;

        TreeLinkNode(int x) {
            val = x;
            left = null;
            right = null;
            next = null;
        }
    }
    public class Solution {
        public void connect(TreeLinkNode A) {
            if (A == null) {
                return;
            }
            Queue<TreeLinkNode> queue = new LinkedList<>();
            queue.add(A);
            queue.add(null);
            ArrayList<Integer> temp = new ArrayList<>();
            boolean reversed = false;
            while (!queue.isEmpty()) {
                TreeLinkNode node = queue.remove();
                if (node != null) {
                    node.next = queue.peek();
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                } else {
                    if (!queue.isEmpty()) {
                        queue.add(null);
                    }
                }
            }
        }
    }
}
