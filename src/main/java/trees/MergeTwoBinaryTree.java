package trees;

public class MergeTwoBinaryTree {
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
        public TreeNode solve(TreeNode A, TreeNode B) {
            if (A == null && B == null) return null;
            if (A == null) return B;
            if (B == null) return A;
            TreeNode node = new TreeNode(A.val + B.val);
            node.left = solve(A.left, B.left);
            node.right = solve(A.right, B.right);
            return node;
        }
    }
}
