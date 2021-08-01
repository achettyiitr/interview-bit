package hashing;

import java.util.HashMap;
import java.util.Map;

public class CheckPalindrome {
    public class Solution {
        public int solve(String A) {
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < A.length(); i++) {
                char ch = A.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            int odds = 0;
            for (Map.Entry<Character, Integer> entry: map.entrySet()) {
                if (entry.getValue() % 2 != 0) {
                    odds++;
                }
            }
            return odds <= 1 ? 1 : 0;
        }
    }
}
