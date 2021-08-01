package math;

import java.util.ArrayList;
import java.util.Arrays;

public class PrimeNumbers {
    public class Solution {
        public ArrayList<Integer> sieve(int A) {
            ArrayList<Integer> result = new ArrayList<>();
            boolean[] dp = new boolean[A + 1];
            Arrays.fill(dp, true);
            dp[0] = false;
            dp[1] = false;
            for (int i = 2; i * i <= A; i++) {
                if (dp[i]) {
                    for (int j = i * i; j <= A; j += i) {
                        dp[j] = false;
                    }
                } else {
                    continue;
                }
            }
            // System.out.println(Arrays.toString(dp));
            for (int i = 2;i <= A; i++) {
                if (dp[i]) {
                    result.add(i);
                }
            }
            return result;
        }
    }
}
