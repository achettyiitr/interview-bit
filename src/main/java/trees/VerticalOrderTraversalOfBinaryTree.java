package trees;

import java.util.*;

public class VerticalOrderTraversalOfBinaryTree {
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
        public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
            Map<Integer, ArrayList<Integer>> map = new HashMap<>();
            Queue<TreeNode> queue = new LinkedList<>();
            Queue<Integer> iqueue = new LinkedList<>();
            if (A != null) {
                queue.add(A);
                iqueue.add(0);
            }
            int minLevel = Integer.MAX_VALUE;
            int maxLevel = Integer.MIN_VALUE;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.remove();
                    int level = iqueue.remove();
                    minLevel = Math.min(minLevel, level);
                    maxLevel = Math.max(maxLevel, level);

                    ArrayList<Integer> list = map.get(level);
                    if (list == null) {
                        list = new ArrayList();
                    }
                    list.add(node.val);
                    map.put(level, list);

                    if (node.left != null) {
                        queue.add(node.left);
                        iqueue.add(level - 1);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                        iqueue.add(level + 1);
                    }
                }
            }
            ArrayList<ArrayList<Integer>> results = new ArrayList<>();
            if (minLevel != Integer.MAX_VALUE && maxLevel != Integer.MIN_VALUE) {
                for (int i = minLevel; i <= maxLevel; i++) {
                    if (map.containsKey(i)) {
                        results.add(map.get(i));
                    }
                }
            }
            return results;
        }
    }
}
