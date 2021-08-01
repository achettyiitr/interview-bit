package arrays;

import java.util.ArrayList;
import java.util.Stack;

public class FindPermutation {
    public class Solution {
        // DO NOT MODIFY THE LIST. IT IS READ ONLY
        public ArrayList<Integer> findPerm(final String A, int B) {
            ArrayList<Integer> result = new ArrayList<>(B);
            Stack<Integer> stack = new Stack<Integer>();
            int counter = 0;
            for (int i = 0; i < A.length(); i++) {
                char ch = A.charAt(i);
                if (ch == 'D') {
                    counter++;
                    stack.add(counter);
                } else {
                    counter++;
                    stack.add(counter);

                    while (!stack.isEmpty()) {
                        result.add(stack.pop());
                    }

                }
            }
            counter++;
            stack.add(counter);

            while (!stack.isEmpty()) {
                result.add(stack.pop());
            }

            return result;
        }
    }
}
