package hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringConcatenation {
    public class Solution {
        // DO NOT MODIFY THE LIST. IT IS READ ONLY
        public ArrayList<Integer> findSubstring(String A, final List<String> B) {
            Map<String, Integer> map = new HashMap<>();
            for (String s: B) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }

            ArrayList<Integer> result = new ArrayList<>();
            int fL = B.get(0).length();
            for (int i = 0; i < A.length(); i++) {
                Map<String, Integer> tmap = new HashMap<>();
                tmap.putAll(map);
                boolean found = false;
                int count = B.size();
                for (int j = i; j <= A.length() - fL; j += fL) {
                    String text = A.substring(j, j + fL);
                    if (tmap.containsKey(text) && tmap.get(text) > 0) {
                        tmap.put(text, tmap.get(text) - 1);
                        count--;
                        if (count == 0) {
                            found = true;
                            break;
                        } else {
                            continue;
                        }
                    } else {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    result.add(i);
                }
            }
            return result;
        }
    }
}
