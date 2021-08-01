package trees;

public class FlattenBinaryTreeToLinkedList {
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
        public TreeNode flatten(TreeNode a) {
            if (a == null) return a;
            if (a.left == null) {
                flatten(a.right);
                return a;
            }
            TreeNode right = a.right;
            TreeNode flattenLeftNode = flatten(a.left);
            TreeNode temp = flattenLeftNode;
            while (temp.right != null) {
                temp = temp.right;
            }
            temp.right = right;
            a.right = flattenLeftNode;
            a.left = null;
            flatten(right);
            return a;
        }
    }
}
