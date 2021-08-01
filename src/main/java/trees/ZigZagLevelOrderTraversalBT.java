package trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class ZigZagLevelOrderTraversalBT {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }
    public class Solution {
        public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
            ArrayList<ArrayList<Integer>> result = new ArrayList<>();
            if (A == null) return result;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(A);
            ArrayList<Integer> temp = new ArrayList<>();
            boolean reversed = false;
            while (!queue.isEmpty()) {
                int size = queue.size();
                temp.clear();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.remove();
                    temp.add(node.val);
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                if (reversed) {
                    Collections.reverse(temp);
                }

                result.add(new ArrayList<>(temp));
                reversed = !reversed;
            }
            return result;
        }
    }
}
