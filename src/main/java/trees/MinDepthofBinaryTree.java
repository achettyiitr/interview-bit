package trees;

public class MinDepthofBinaryTree {
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
        public int minDepth(TreeNode A) {
            int[] depth = new int[] {Integer.MAX_VALUE};
            minDepthUtil(A, depth, 1);
            if (depth[0] == Integer.MAX_VALUE) {
                return 0;
            } else {
                return depth[0];
            }
        }

        public void minDepthUtil(TreeNode A, int[] depth, int level) {
            if (A == null) {
                return;
            }
            if (A.left == null && A.right == null) {
                depth[0] = Math.min(depth[0], level);
            }
            minDepthUtil(A.left, depth, level + 1);
            minDepthUtil(A.right, depth, level + 1);
        }
    }
}
