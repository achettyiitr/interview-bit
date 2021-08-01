package trees;

public class BalancedBinaryTree {
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
        public int isBalanced(TreeNode A) {
            boolean[] isBalanced = new boolean[] {true};
            isBalancedUtil(A, isBalanced);
            return isBalanced[0] ? 1 : 0;
        }

        private int isBalancedUtil(TreeNode A, boolean[] isBalanced) {
            if (A == null) return 0;
            int lHeight = isBalancedUtil(A.left, isBalanced);
            int rHeight = isBalancedUtil(A.right, isBalanced);
            if (Math.abs(lHeight - rHeight) > 1) {
                isBalanced[0] = false;
            }
            return 1 + Math.max(lHeight , rHeight);
        }
    }
}
