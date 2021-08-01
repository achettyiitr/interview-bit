package hashing;

import java.util.HashMap;
import java.util.Map;

public class SubstringWithoutRepeatLongestSubstringWithoutRepeat {
    public class Solution {
        public int lengthOfLongestSubstring(String A) {
            int lpr = -1, maxL = 0;
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < A.length(); i++) {
                char ch = A.charAt(i);
                lpr = Math.max(lpr, map.getOrDefault(ch, -1));
                maxL = Math.max(maxL, i - lpr);
                map.put(ch, i);
            }
            return maxL;
        }
    }
}
