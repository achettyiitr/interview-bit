package trees;

public class RemoveHalfNodes {
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
        public TreeNode solve(TreeNode A) {
            if (A == null) return A;
            if (A.left == null && A.right == null) return A;
            A.left = solve(A.left);
            A.right = solve(A.right);
            if (A.left != null && A.right != null) {
                return A;
            } else {
                if (A.left != null) return A.left;
                else return A.right;
            }
        }
    }
}
