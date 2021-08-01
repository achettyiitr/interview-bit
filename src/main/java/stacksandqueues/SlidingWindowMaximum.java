package stacksandqueues;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SlidingWindowMaximum {
    public class Solution {
        // DO NOT MODIFY THE LIST. IT IS READ ONLY
        public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
            int n = A.size();
            int i = 0, j = 0;
            ArrayList<Integer> result = new ArrayList<>();
            Deque<Integer> queue = new ArrayDeque<>();
            while (j < n) {
                while (!queue.isEmpty() && queue.peekLast() < A.get(j)) {
                    queue.removeLast();
                }
                queue.addLast(A.get(j));
                if (j - i + 1 < B) {
                    j++;
                } else {
                    result.add(queue.peekFirst());
                    if (A.get(i) == queue.peekFirst()) {
                        queue.removeFirst();
                    }
                    i++;
                    j++;
                }
            }
            return result;
        }
    }
}
