package math;

import java.util.ArrayList;

public class AllFactors {
    public class Solution {
        public ArrayList<Integer> allFactors(int A) {
            ArrayList<Integer> result =  new ArrayList<>();
            int start = 0, end = 0;
            for (int i = 1; i * i <= A; i++) {
                if (A % i == 0) {
                    if (i != A/i) {
                        result.add(start, i);
                        result.add(result.size() - start, A / i);
                    } else {
                        result.add(start, i);
                    }
                    start++;
                }
            }
            return result;
        }
    }
}
