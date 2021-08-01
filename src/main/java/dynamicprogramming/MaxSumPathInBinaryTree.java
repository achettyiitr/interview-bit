package dynamicprogramming;

public class MaxSumPathInBinaryTree {
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
        public int maxPathSum(TreeNode A) {
            int result[] = new int[]{Integer.MIN_VALUE};
            maxPathSum(A, result);
            return result[0];
        }

        public int maxPathSum(TreeNode A, int[] msum) {
            if (A == null) {
                return 0;
            }
            int left = maxPathSum(A.left, msum);
            int right = maxPathSum(A.right, msum);
            int maxLR = Math.max(left, right);
            int maxPS = Math.max(A.val, A.val + maxLR);
            msum[0] = Math.max(msum[0], Math.max(left + right + A.val, maxPS));
            return maxPS;
        }
    }

}
