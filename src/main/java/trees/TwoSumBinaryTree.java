package trees;

import java.util.Stack;

public class TwoSumBinaryTree {
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
        public int t2Sum(TreeNode A, int B) {
            Stack<Pair> io = new Stack<>(), rio  = new Stack<>();
            io.push(new Pair(A, 1));
            rio.push(new Pair(A, 1));
            TreeNode node1 = getInOrderNode(io);
            TreeNode node2 = getReversedInOrderNode(rio);
            while (node1.val < node2.val) {
                int sum = node1.val + node2.val;
                if (sum > B) {
                    node2 = getReversedInOrderNode(rio);
                } else if (sum < B) {
                    node1 = getInOrderNode(io);
                } else {
                    return 1;
                }
            }
            return 0;
        }

        private TreeNode getInOrderNode(Stack<Pair> stack) {
            while (!stack.isEmpty()) {
                Pair pair = stack.peek();
                switch(pair.state) {
                    case 1:  {
                        pair.state++;
                        if (pair.node.left != null) {
                            stack.push(new Pair(pair.node.left, 1));
                        }
                        break;
                    }
                    case 2:  {
                        pair.state++;
                        if (pair.node.right != null) {
                            stack.push(new Pair(pair.node.right, 1));
                        }
                        return pair.node;
                    }
                    case 3:  {
                        stack.pop();
                        break;
                    }
                }
            }
            return null;
        }

        private TreeNode getReversedInOrderNode(Stack<Pair> stack) {
            while (!stack.isEmpty()) {
                Pair pair = stack.peek();
                switch(pair.state) {
                    case 1:  {
                        pair.state++;
                        if (pair.node.right != null) {
                            stack.push(new Pair(pair.node.right, 1));
                        }
                        break;
                    }
                    case 2:  {
                        pair.state++;
                        if (pair.node.left != null) {
                            stack.push(new Pair(pair.node.left, 1));
                        }
                        return pair.node;
                    }
                    case 3:  {
                        stack.pop();
                        break;
                    }
                }
            }
            return null;
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
