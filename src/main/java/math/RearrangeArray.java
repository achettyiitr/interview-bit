package math;

import java.util.ArrayList;

public class RearrangeArray {
    public class Solution {
        public void arrange(ArrayList<Integer> a) {
            int n = a.size();
            for (int i = 0; i < n; i++) {
                int index = a.get(i) % n;
                int indexval = a.get(index) % n;
                int newval = a.get(i) + n * indexval;
                a.set(i, newval);
            }
            for (int i = 0; i < n; i++) {
                a.set(i, a.get(i) / n);
            }
        }
    }
}
