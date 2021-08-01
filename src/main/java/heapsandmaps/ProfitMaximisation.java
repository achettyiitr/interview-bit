package heapsandmaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ProfitMaximisation {
    public class Solution {
        public int solve(ArrayList<Integer> A, int B) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
            for (int i: A) pq.add(i);
            int sum = 0;
            for (int i = 0; i < B; i++) {
                int rate = pq.remove();
                sum += rate;
                pq.add(rate - 1);
            }
            return sum;
        }
    }
}
