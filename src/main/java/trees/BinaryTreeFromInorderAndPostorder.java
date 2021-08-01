package trees;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeFromInorderAndPostorder {
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
        public TreeNode buildTree(int[] B, int[] A) {
            int n = A.length;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                map.put(B[i], i);
            }
            return buildTree(A, B, 0, n - 1, 0, n - 1, map);
        }

        public TreeNode buildTree(int[] A, int[] B, int poststart, int postend, int instart, int inend, Map<Integer, Integer> map) {
            if (instart > inend || poststart > postend) {
                return null;
            }
            TreeNode root = new TreeNode(A[postend]);
            int index = map.get(A[postend]);
            int length = inend - index;
            root.right = buildTree(A, B, postend - length, postend - 1, index + 1, inend, map);
            root.left = buildTree(A, B, poststart, postend - length - 1, instart, index - 1, map);
            return root;
        }
    }
}
