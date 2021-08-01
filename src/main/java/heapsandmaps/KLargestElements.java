package heapsandmaps;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class KLargestElements {
    public class Solution {
        public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            int count = 0;
            while (count < B) {
                pq.add(A.get(count++));
            }
            while (count < A.size()) {
                if (pq.peek() < A.get(count)) {
                    pq.remove();
                    pq.add(A.get(count));
                }
                count++;
            }
            ArrayList<Integer> result = new ArrayList<>();
            while(!pq.isEmpty()) {
                result.add(pq.remove());
            }
            return result;
        }
    }
}
