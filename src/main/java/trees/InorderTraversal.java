package trees;

import java.util.ArrayList;
import java.util.Stack;

public class InorderTraversal {
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
        public ArrayList<Integer> inorderTraversal(TreeNode A) {
            ArrayList<Integer> result = new ArrayList<>();
            Stack<Pair> stack = new Stack<>();
            stack.add(new Pair(A, 1));
            while (!stack.isEmpty()) {
                Pair pair = stack.peek();
                switch (pair.state) {
                    case 1: {
                        pair.state++;
                        if (pair.node.left != null) {
                            stack.push(new Pair(pair.node.left, 1));
                        }
                        break;
                    }
                    case 2: {
                        result.add(pair.node.val);
                        pair.state++;
                        if (pair.node.right != null) {
                            stack.push(new Pair(pair.node.right, 1));
                        }
                        break;
                    }
                    case 3: {
                        stack.pop();
                    }
                }
            }
            return result;
        }

        class Pair {
            TreeNode node;
            int state;
            Pair(TreeNode node, int state) {
                this.node = node;
                this.state = state;
            }
        }
    }
}
