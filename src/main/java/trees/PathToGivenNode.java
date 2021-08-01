package trees;

import java.util.ArrayList;

public class PathToGivenNode {
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
        public ArrayList<Integer> solve(TreeNode A, int B) {
            ArrayList<Integer> result = new ArrayList<>();
            solve(A, B, result);
            return result;
        }

        private boolean solve(TreeNode A, int B, ArrayList<Integer> result) {
            if (A == null) {
                return false;
            }
            result.add(A.val);
            if (A.val == B) {
                return true;
            }
            if (solve(A.left, B, result)) {
                return true;
            } else if (solve(A.right, B, result)){
                return true;
            }
            result.remove(result.size() - 1);
            return false;
        }
    }
}
