package trees;

import java.util.ArrayList;

public class RootToLeafPathsWithSum {
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
        public ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B) {
            ArrayList<ArrayList<Integer>> result = new ArrayList<>();
            pathSumUtil(A, B, result, new ArrayList<Integer>());
            return result;
        }

        public void pathSumUtil(TreeNode A, int B, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp) {
            if (A == null) {
                return;
            }
            temp.add(A.val);
            if (A.val == B && A.left == null && A.right == null) {
                result.add(new ArrayList<>(temp));
            }
            pathSumUtil(A.left, B - A.val, result, temp);
            pathSumUtil(A.right, B - A.val, result, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
