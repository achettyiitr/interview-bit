package trees;

import java.util.Stack;

public class BSTIterator {
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
        Stack<Pair> stack;
        TreeNode curr;

        public Solution(TreeNode root) {
            this.stack = new Stack<>();
            if (root != null) {
                this.stack.push(new Pair(root, 1));
            }
            this.curr = getNextReversedInOrder();
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return curr != null;
        }

        /** @return the next smallest number */
        public int next() {
            if (hasNext()) {
                int value = curr.val;
                curr = getNextReversedInOrder();
                return value;
            } else {
                return -1;
            }
        }

        private TreeNode getNextReversedInOrder() {
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
                        pair.state++;
                        if (pair.node.right != null) {
                            stack.push(new Pair(pair.node.right, 1));
                        }
                        return pair.node;
                    }
                    case 3: {
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

/**
 * Your Solution will be called like this:
 * Solution i = new Solution(root);
 * while (i.hasNext()) System.out.print(i.next());
 */
}
