package strings;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public class Solution {
        public int romanToInt(String A) {
            int result = 0;
            Map<Character, Integer> map = new HashMap<>();
            map.put('I', 1);
            map.put('V', 5);
            map.put('X', 10);
            map.put('L', 50);
            map.put('C', 100);
            map.put('D', 500);
            map.put('M', 1000);

            result += map.get(A.charAt(0));
            for (int i = 1; i < A.length(); i++) {
                int val1 = map.get(A.charAt(i));
                int val2 = map.get(A.charAt(i - 1));
                if (val1 > val2) {
                    result += val1;
                    result -= 2 * val2;
                } else {
                    result += val1;
                }
            }
            return result;
        }
    }
}
