package trees;

import java.util.ArrayList;

public class RightViewOfBinarytree {
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
        public ArrayList<Integer> solve(TreeNode A) {
            ArrayList<Integer> result = new ArrayList<>();
            sovleUtil(A, new int[] {0}, 1, result);
            return result;
        }

        private void sovleUtil(TreeNode A, int[] pos, int level, ArrayList<Integer> result) {
            if (A == null) return;
            if (level > pos[0]) {
                result.add(A.val);
                pos[0] = level;
            }
            sovleUtil(A.right, pos, level + 1, result);
            sovleUtil(A.left, pos, level + 1, result);
        }
    }
}
