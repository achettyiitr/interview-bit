package dynamicprogramming;

import java.util.ArrayList;

public class SmallestSequenceWithGivenPrimes {
    public class Solution {
        public ArrayList<Integer> solve(int A, int B, int C, int D) {
            ArrayList<Integer> result = new ArrayList<>();
            result.add(1);
            int i = 0, j = 0, k = 0, a = 0, b = 0, c = 0, s = 0;
            while (result.size() != D + 1) {
                a = A * result.get(i);
                b = B * result.get(j);
                c = C * result.get(k);
                s = Math.min(a, Math.min(b, c));
                if (result.isEmpty() || result.get(result.size() - 1) != s) {
                    result.add(s);
                }

                if (a == s) i++;
                else if (b == s) j++;
                else k++;
            }
            result.remove(0);
            return result;
        }
    }
}
