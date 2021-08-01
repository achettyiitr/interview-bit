package hashing;

import java.util.HashMap;
import java.util.Map;

public class WindowString {
    public class Solution {
        public String minWindow(String A, String B) {
            Map<Character, Integer> map = new HashMap<>();
            for (char ch: B.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            int count = map.size();

            int i = 0, j = 0, n = A.length(), start = -1, end = -1, length = Integer.MAX_VALUE;
            while (j < n) {
                char ch = A.charAt(j);
                if (map.containsKey(ch)) {
                    map.put(ch, map.get(ch) - 1);
                    if (map.get(ch) == 0) {
                        count--;
                    }
                }
                if (count > 0) {
                    j++;
                } else {
                    while (count == 0) {
                        if (j - i + 1 < length) {
                            length = j - i + 1;
                            start = i;
                            end = j;
                        }
                        char jh = A.charAt(i);
                        if (map.containsKey(jh)) {
                            map.put(jh, map.get(jh) + 1);
                            if (map.get(jh) == 1) {
                                count++;
                            }
                        }
                        i++;
                    }
                    j++;
                }
            }
            // System.out.println("start: " + start);
            // System.out.println("end: " + end);
            if (length == Integer.MAX_VALUE) {
                return "";
            } else {
                return A.substring(start, end + 1);
            }
        }
    }
}
