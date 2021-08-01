package trees;

import java.util.*;

public class ReverseLevelOrder {
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
        public ArrayList<Integer> solve(TreeNode A) {
            ArrayList<Integer> result = new ArrayList<>();
            if (A == null) return result;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(A);
            Stack<Integer> stack = new Stack<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.remove();
                stack.add(node.val);
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
            }
            Collections.reverse(stack);
            return new ArrayList<>(stack);
        }
    }
}
