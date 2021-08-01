package stacksandqueues;

import java.util.Stack;

public class MinStack {
    class Solution {
        Stack<Integer> s = new Stack<>();
        Stack<Integer> ms = new Stack();

        public void push(int x) {
            s.push(x);
            if (ms.isEmpty()) {
                ms.push(x);
            } else {
                ms.push(Math.min(ms.peek(), x));
            }
        }

        public void pop() {
            if (!isEmpty()) {
                s.pop();
                ms.pop();
            }
        }

        public int top() {
            if (isEmpty()) return -1;
            else return s.peek();
        }

        public int getMin() {
            if (isEmpty()) return -1;
            else return ms.peek();
        }

        private boolean isEmpty() {
            return s.isEmpty();
        }
    }
}
