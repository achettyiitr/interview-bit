package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CousinsInBinaryTree {
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
        public ArrayList<Integer> solve(TreeNode A, int B) {
            ArrayList<Integer> result = new ArrayList<>();
            if (A == null || A.val == B) {
                return result;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(A);
            while (!queue.isEmpty()) {
                int size = queue.size();
                boolean found = false;
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.remove();
                    if (node.left != null && node.right != null) {
                        if (node.left.val == B || node.right.val == B) {
                            found = true;
                        } else {
                            queue.add(node.left);
                            queue.add(node.right);
                        }
                    } else  if (node.left != null) {
                        if (B == node.left.val) {
                            found = true;
                        } else {
                            queue.add(node.left);
                        }
                    } else  if (node.right != null) {
                        if (B == node.right.val) {
                            found = true;
                        } else {
                            queue.add(node.right);
                        }
                    }
                }
                if (found) {
                    break;
                }
            }
            while (!queue.isEmpty()) {
                TreeNode node = queue.remove();
                result.add(node.val);
            }
            return result;
        }
    }
}
