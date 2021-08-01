package trees;

public class MaxDepthOfBinaryTree {
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
        public int maxDepth(TreeNode A) {
            if (A == null) return 0;
            else return 1 + Math.max(maxDepth(A.left), maxDepth(A.right));
        }
    }
}
