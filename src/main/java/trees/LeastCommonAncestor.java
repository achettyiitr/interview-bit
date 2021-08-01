package trees;

public class LeastCommonAncestor {
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
        public int lca(TreeNode A, int B, int C) {
            TreeNode[] result = new TreeNode[] {null};
            lcaUtil(A, B, C, result);
            if (result[0] == null) {
                return -1;
            } else {
                return result[0].val;
            }
        }

        private TreeNode lcaUtil(TreeNode A, int B, int C, TreeNode[] result) {
            if (A == null) return null;
            TreeNode lcaL = lcaUtil(A.left, B, C, result);
            TreeNode lcaR = lcaUtil(A.right, B, C, result);
            if (A.val == B || A.val == C)  {
                if (lcaL != null || lcaR != null || (B == C)) {
                    result[0] = A;
                }
                return A;
            }
            if (lcaL != null && lcaR != null) {
                result[0] = A;
                return A;
            }
            if (lcaL != null) return lcaL;
            else return lcaR;
        }
    }
}
