package hashing;

import java.util.HashSet;
import java.util.Set;

public class ColorfulNumber {
    public class Solution {
        public int colorful(int A) {
            Set<Integer> set = new HashSet<>();
            String s = String.valueOf(A);
            for (int i = 0; i < s.length(); i++) {
                int val = 1;
                for (int j = i; j < s.length(); j++) {
                    char ch = s.charAt(j);
                    val = val * (ch - '0');
                    if (set.contains(val)) return 0;
                    else set.add(val);
                }
            }
            return 1;
        }
    }
}
