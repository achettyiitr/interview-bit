package trees;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPreorder {
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
        public TreeNode buildTree(int[] A, int[] B) {
            int n = A.length;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                map.put(B[i], i);
            }
            return buildTree(A, B, 0, n - 1, 0, n - 1, map);
        }

        public TreeNode buildTree(int[] A, int[] B, int prestart, int preend, int instart, int inend, Map<Integer, Integer> map) {
            if (instart > inend || prestart > preend) {
                return null;
            }
            TreeNode root = new TreeNode(A[prestart]);
            int index = map.get(A[prestart]);
            int length = index - instart;
            root.left = buildTree(A, B, prestart + 1, prestart + length, instart, index - 1, map);
            root.right = buildTree(A, B, prestart + length + 1, preend, index + 1, inend, map);
            return root;
        }
    }
}
