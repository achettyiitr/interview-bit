package trees;

public class SumRootToLeafNumbers {
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
        private int mod = 1003;

        public int sumNumbers(TreeNode A) {
            int[] result = new int[] {0};
            sumNumbersUtil(A, 0, result);
            return result[0];
        }

        private void sumNumbersUtil(TreeNode A, int sum, int[] result) {
            if (A == null) return;
            int a = (sum%mod * 10%mod)%mod;
            int nsum = (a%mod + A.val%mod)%mod;
            if (A.left == null && A.right == null) {
                result[0] = (result[0]%mod + nsum%mod)%mod;
                return;
            }
            sumNumbersUtil(A.left, nsum, result);
            sumNumbersUtil(A.right, nsum, result);
        }
    }
}
