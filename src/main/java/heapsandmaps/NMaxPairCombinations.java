package heapsandmaps;

import java.util.*;

public class NMaxPairCombinations {
    public class Solution {
        public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
            Collections.sort(A, Comparator.reverseOrder());
            Collections.sort(B, Comparator.reverseOrder());
            PriorityQueue<Data> pq = new PriorityQueue<>(new Comparator<Data>() {
                @Override
                public int compare(Data a, Data b) {
                    return Integer.compare(A.get(b.i1) + B.get(b.i2), A.get(a.i1) + B.get(a.i2));
                }
            });
            pq.add(new Data(0, 0));
            int n = A.size();
            Set<String> set = new HashSet<>();
            ArrayList<Integer> result = new ArrayList<>();
            for (int i = 0; i < A.size(); i++) {
                Data d = pq.remove();
                result.add(A.get(d.i1) + B.get(d.i2));
                String d1 = (d.i1 + 1) + "-" + (d.i2);
                String d2 = (d.i1) + "-" + (d.i2 + 1);
                if (d.i1 + 1 < n && !set.contains(d1)) {
                    pq.add(new Data(d.i1 + 1, d.i2));
                    set.add(d1);
                }
                if (d.i2 + 1 < n && !set.contains(d2)) {
                    pq.add(new Data(d.i1, d.i2 + 1));
                    set.add(d2);
                }
            }
            return result;
        }

        class Data {
            int i1;
            int i2;
            Data(int i1, int i2) {
                this.i1 = i1;
                this.i2 = i2;
            }
        }
    }
}
