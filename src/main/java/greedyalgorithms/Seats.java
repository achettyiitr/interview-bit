package greedyalgorithms;

import java.util.ArrayList;

public class Seats {
    public class Solution {
        public int seats(String A) {
            int n = A.length();
            ArrayList<Integer> positions = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                char ch = A.charAt(i);
                if (ch == 'x') {
                    positions.add(i);
                }
            }
            int sum = 0, n1 = positions.size(), jumps = 0;
            if (n1 == 0) {
                return jumps;
            }
            int midPosition = positions.get(n1 / 2);
            for (int i = 0; i < n1; i++) {
                int currentPosition = positions.get(i);
                int actualPosition = midPosition - (n1 / 2) + i;
                jumps = (jumps % 10000003 + Math.abs(currentPosition - actualPosition) % 10000003) % 10000003;
            }
            return jumps;
        }
    }
}
