package stacksandqueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class FirstNonRepeatingCharacterInAStreamOfcharacters {
    public class Solution {
        public String solve(String A) {
            Deque<Character> deque = new ArrayDeque<>();
            Set<Character> set = new HashSet<>();
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < A.length(); i++) {
                char ch = A.charAt(i);
                if (set.contains(ch)) {
                    deque.remove(ch);
                } else {
                    set.add(ch);
                    deque.addLast(ch);
                }
                if (deque.isEmpty()) {
                    sb.append('#');
                } else {
                    sb.append(deque.peekFirst());
                }
            }
            return sb.toString();
        }
    }
}
