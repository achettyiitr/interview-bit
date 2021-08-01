package trees;

public class InvertTheBinaryTree {
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
        public TreeNode invertTree(TreeNode A) {
            if (A == null) return A;
            A.left = invertTree(A.left);
            A.right = invertTree(A.right);
            TreeNode temp = A.left;
            A.left = A.right;
            A.right = temp;
            return A;
        }
    }
}
