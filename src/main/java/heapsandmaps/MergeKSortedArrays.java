package heapsandmaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedArrays {
    public class Solution {
        public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {
            PriorityQueue<Data> pq = new PriorityQueue<>(new Comparator<Data>(){
                @Override
                public int compare(Data a, Data b) {
                    return Integer.compare(A.get(a.pos).get(a.index), A.get(b.pos).get(b.index));
                }
            });
            for (int i = 0; i < A.size(); i++) {
                int size = A.get(i).size();
                if (size != 0) {
                    pq.add(new Data(i, size));
                }
            }
            ArrayList<Integer> result = new ArrayList<>();
            while (!pq.isEmpty()) {
                Data d = pq.remove();
                result.add(A.get(d.pos).get(d.index));
                d.index++;
                if (d.index < d.size) {
                    pq.add(d);
                }
            }
            return result;
        }

        class Data {
            int index;
            int pos;
            int size;

            Data(int pos, int size) {
                this.index = 0;
                this.pos = pos;
                this.size = size;
            }
        }
    }
}
