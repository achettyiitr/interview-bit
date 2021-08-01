package trees;

public class SortedArrayToBalancedBST {
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
        // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
        public TreeNode sortedArrayToBST(final int[] A) {
            return sortedArrayToBSTUtil(A, 0, A.length - 1);
        }

        private TreeNode sortedArrayToBSTUtil(final int[] A, int start, int end) {
            if (start > end) return null;
            int mid = (start + end) >>> 1;
            TreeNode root = new TreeNode(A[mid]);
            root.left = sortedArrayToBSTUtil(A, start, mid - 1);
            root.right = sortedArrayToBSTUtil(A, mid + 1, end);
            return root;
        }
    }
}
