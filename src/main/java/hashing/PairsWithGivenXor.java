package hashing;

import java.util.HashSet;
import java.util.Set;

public class PairsWithGivenXor {
    public class Solution {
        public int solve(int[] A, int B) {
            Set<Integer> set = new HashSet<>();
            for (int i: A) {
                set.add(i);
            }
            int count = 0;
            for (int i: A) {
                if (set.contains(B ^ i)) count++;
                else continue;
            }
            return count / 2;
        }
    }
}
