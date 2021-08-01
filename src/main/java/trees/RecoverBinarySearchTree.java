package trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class RecoverBinarySearchTree {
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
        public ArrayList<Integer> recoverTree(TreeNode A) {
            ArrayList<Integer> result = new ArrayList<>();
            Stack<Data> inOrder = new Stack<>();
            Stack<Data> rnOrder = new Stack<>();
            inOrder.push(new Data(A, 1));
            rnOrder.push(new Data(A, 1));

            TreeNode start = getInOrderIterator(inOrder), next = null;
            while (start != null) {
                next = getInOrderIterator(inOrder);
                if (next != null && start.val > next.val) {
                    result.add(start.val);
                    break;
                } else {
                    start = next;
                }
            }

            start = getReverseInOrderIterator(rnOrder);
            while (start != null) {
                next = getReverseInOrderIterator(rnOrder);
                if (next != null && start.val < next.val) {
                    result.add(start.val);
                    break;
                } else {
                    start = next;
                }
            }

            Collections.reverse(result);
            return result;
        }

        private TreeNode getInOrderIterator(Stack<Data> stack) {
            while (!stack.isEmpty()) {
                Data data = stack.peek();
                if (data.state == 1) {
                    data.state++;
                    if (data.node.left != null) {
                        stack.push(new Data(data.node.left, 1));
                    }
                } else if (data.state == 2) {
                    data.state++;
                    if (data.node.right != null) {
                        stack.push(new Data(data.node.right, 1));
                    }
                    return data.node;
                } else {
                    stack.pop();
                }
            }
            return null;
        }

        private TreeNode getReverseInOrderIterator(Stack<Data> stack) {
            while (!stack.isEmpty()) {
                Data data = stack.peek();
                if (data.state == 1) {
                    data.state++;
                    if (data.node.right != null) {
                        stack.push(new Data(data.node.right, 1));
                    }
                } else if (data.state == 2) {
                    data.state++;
                    if (data.node.left != null) {
                        stack.push(new Data(data.node.left, 1));
                    }
                    return data.node;
                } else {
                    stack.pop();
                }
            }
            return null;
        }

        class Data {
            TreeNode node;
            int state;
            Data(TreeNode node, int state) {
                this.node = node;
                this.state = state;
            }
        }
    }
}
