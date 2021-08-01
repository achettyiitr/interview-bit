package strings;

import java.util.HashMap;
import java.util.Map;

public class ZigzagString {
    public class Solution {
        public String convert(String A, int B) {
            if (B == 0 || B == 1) return A;
            Map<Integer, StringBuilder> map = new HashMap<>();
            for (int i = 0; i < B; i++) {
                map.put(i, new StringBuilder(""));
            }
            int pos = 1;
            boolean increasing = true;
            for (int i = 0; i < A.length(); i++) {
                char ch = A.charAt(i);
                map.get(pos - 1).append(ch);
                if (increasing) pos++;
                else pos--;
                if (pos == 1) {
                    increasing = true;
                } else if (pos == B) {
                    increasing = false;
                }
            }
            // map.entrySet().forEach(entry -> {
            //     System.out.println(entry.getKey() + " -> " + entry.getValue());
            // });
            StringBuilder result = new StringBuilder("");
            for (int i = 0; i < B; i++) {
                result.append(map.get(i));
            }
            return result.toString();
        }
    }
}
