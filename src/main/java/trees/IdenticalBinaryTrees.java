package trees;

public class IdenticalBinaryTrees {
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
        public int isSameTree(TreeNode A, TreeNode B) {
            return isSymmetric(A, B) ? 1 : 0;
        }

        private boolean isSymmetric(TreeNode A, TreeNode B) {
            if (A == null && B == null)
                return true;
            if (A == null || B == null)
                return false;
            return A.val == B.val && isSymmetric(A.left, B.left) && isSymmetric(A.right, B.right);
        }
    }
}
