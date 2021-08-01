package hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PointsOnTheStraightLine {
    public class Solution {
        public int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {
            int n = a.size(), maxPoints = 0;
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                map.clear();
                int currmax = 0, verticalpoints = 0, similarpoints = 0;
                for (int j = i + 1; j < n; j++) {
                    if (a.get(i) == a.get(j) && b.get(i) == b.get(j)) {
                        similarpoints++;
                    } else if (a.get(i) == a.get(j)) {
                        verticalpoints++;
                    } else {
                        int xdiff = a.get(j) - a.get(i);
                        int ydiff = b.get(j) - b.get(i);
                        int gcd = gcd(xdiff, ydiff);
                        int x = xdiff/gcd;
                        int y = ydiff/gcd;
                        String key = x + "-" + y;
                        if (map.containsKey(key)) {
                            map.put(key, map.get(key) + 1);
                        } else {
                            map.put(key, 1);
                        }
                        currmax = Math.max(currmax, map.get(key));
                    }
                    currmax = Math.max(currmax, verticalpoints);
                }
                maxPoints = Math.max(maxPoints, currmax + similarpoints + 1);
            }
            return maxPoints;
        }

        private int gcd(int a, int b) {
            if (b == 0) return a;
            else return gcd(b, a % b);
        }
    }
}
