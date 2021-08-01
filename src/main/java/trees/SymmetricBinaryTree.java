package trees;

public class SymmetricBinaryTree {
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
        public int isSymmetric(TreeNode A) {
            if (A == null) return 1;
            else return isSymmetric(A.left, A.right) ? 1 : 0;
        }

        private boolean isSymmetric(TreeNode A, TreeNode B) {
            if (A == null && B == null) return true;
            if (A == null || B == null) return false;
            return A.val == B.val && isSymmetric(A.left, B.right) && isSymmetric(A.right, B.left);
        }
    }
}
