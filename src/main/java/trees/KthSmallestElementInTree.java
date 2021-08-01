package trees;

public class KthSmallestElementInTree {
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
        public int kthsmallest(TreeNode A, int B) {
            TreeNode kthNode = inOrderKthNode(A, B, new int[]{0});
            if (kthNode == null) {
                return -1;
            } else {
                return kthNode.val;
            }
        }

        public TreeNode inOrderKthNode(TreeNode A, int B, int[] count) {
            if (A == null) {
                return A;
            }
            TreeNode left = inOrderKthNode(A.left, B, count);
            if (left != null) return left;
            count[0]++;
            if (count[0] == B) {
                return A;
            }
            TreeNode right = inOrderKthNode(A.right, B, count);
            if (right != null) return right;
            return null;
        }
    }
}
