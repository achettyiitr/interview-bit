package dynamicprogramming;

import java.util.ArrayList;
import java.util.HashSet;

public class WordBreak {
    public class Solution {
        public int wordBreak(String A, ArrayList<String> B) {
            HashSet<String> set = new HashSet<>();
            for (String s : B) {
                set.add(s);
            }

            int n = A.length();
            boolean[] dp = new boolean[n + 1];
            dp[0] = true;
            for (int i = 1; i <= n; i++) {
                for (int j = i; j >= 1 && (i - j) <= 20; j--) {
                    String word = A.substring(j - 1, i);
                    if (dp[j - 1] && set.contains(word)) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[n] ? 1 : 0;
        }
    }
}
