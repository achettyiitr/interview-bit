package trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DiagonalTraversal {
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
            Map<Integer, ArrayList<Integer>> map = new HashMap<>();
            solveUtil(A, 0, result, map);
            int minLevel = Integer.MAX_VALUE;
            for (int i: map.keySet()) {
                minLevel = Math.min(minLevel, i);
            }
            if (minLevel != Integer.MAX_VALUE) {
                for (int i = 0; i >= minLevel; i--) {
                    if (map.containsKey(i)) {
                        result.addAll(map.get(i));
                    }
                }
            }
            return result;
        }

        public void solveUtil(TreeNode A, int level, ArrayList<Integer> result, Map<Integer, ArrayList<Integer>> map) {
            if (A == null) return;
            solveUtil(A.right, level, result, map);
            solveUtil(A.left, level - 1, result, map);
            ArrayList<Integer> list = map.get(level);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(0, A.val);
            map.put(level, list);
        }
    }
}
