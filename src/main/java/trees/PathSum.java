package trees;

public class PathSum {
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
        public int hasPathSum(TreeNode A, int B) {
            if (hasPathSumUtil(A, B)) return 1;
            else return 0;
        }

        public boolean hasPathSumUtil(TreeNode A, int B) {
            if (A == null) return false;
            if (A.val == B && A.left == null && A.right == null) return true;
            return hasPathSumUtil(A.left, B - A.val) || hasPathSumUtil(A.right, B - A.val);
        }
    }
}
