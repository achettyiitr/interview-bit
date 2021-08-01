package trees;

public class BurnATree {
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
        public int solve(TreeNode A, int B) {
            int[] result = new int[1];
            solve(A, B, result);
            return result[0];
        }

        public int solve(TreeNode A, int B, int[] result) {
            if (A == null) {
                return 0;
            }
            if (A.val == B) {
                return 1;
            }
            int leftBurn = solve(A.left, B, result);
            if (leftBurn != 0) {
                result[0] = Math.max(result[0], leftBurn + height(A.right));
                return leftBurn + 1;
            }
            int rightBurn = solve(A.right, B, result);
            if (rightBurn != 0) {
                result[0] = Math.max(result[0], rightBurn + height(A.left));
                return rightBurn + 1;
            }
            return 0;
        }

        private int height(TreeNode A) {
            if (A == null) {
                return 0;
            }
            return 1 + Math.max(height(A.left), height(A.right));
        }
    }
}
