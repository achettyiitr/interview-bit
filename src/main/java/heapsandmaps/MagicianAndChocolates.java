package heapsandmaps;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MagicianAndChocolates {
    public class Solution {
        public int nchoc(int A, int[] B) {
            Arrays.sort(B);
            PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer a, Integer b) {
                    return Integer.compare(B[b], B[a]);
                }
            });
            int n = B.length;
            for (int i = 0; i < n; i++) {
                pq.add(i);
            }

            int chocolates = 0;
            int mod = (int)Math.pow(10, 9) + 7;
            for (int i = 0; i < A; i++) {
                int index = pq.remove();
                chocolates = (chocolates%mod + B[index]%mod)%mod;
                B[index] = B[index] / 2;
                pq.add(index);
            }
            return chocolates;
        }
    }
}
