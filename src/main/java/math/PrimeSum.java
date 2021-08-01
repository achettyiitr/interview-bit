package math;

import java.util.Arrays;

public class PrimeSum {
    public class Solution {
        public int[] primesum(int A) {
            boolean pf[] = new boolean[A + 1];
            Arrays.fill(pf, true);
            pf[0] = false;
            pf[1] = false;
            for (int i = 2; i * i <= A; i++) {
                if (pf[i]) {
                    long jj = i * i;
                    int j = (int)jj;
                    for (; j <= A; j += i) {
                        pf[j] = false;
                    }
                } else {
                    continue;
                }
            }
            for (int i = 2; i <= A; i++) {
                if (pf[i] && pf[A - i]) {
                    return new int[] {i, A - i};
                }
            }
            return new int[] {-1, -1};
        }
    }
}
