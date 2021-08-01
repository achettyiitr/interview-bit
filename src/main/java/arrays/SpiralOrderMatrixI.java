package arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrderMatrixI {
    public class Solution {
        // DO NOT MODIFY THE LIST. IT IS READ ONLY
        public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> A) {
            int m = A.size();
            int n = A.get(0).size();
            int l = 0, r = n - 1, t = 0, b = m - 1;
            ArrayList<Integer> result = new ArrayList<>();
            int direction = 0;
            while (l <= r && t <= b) {
                if (direction == 0) {
                    for (int i = l; i <= r; i++) {
                        result.add(A.get(t).get(i));
                    }
                    t++;
                } else if (direction == 1) {
                    for (int i = t; i <= b; i++) {
                        result.add(A.get(i).get(r));
                    }
                    r--;
                } else if (direction == 2) {
                    for (int i = r; i >= l; i--) {
                        result.add(A.get(b).get(i));
                    }
                    b--;
                } else if (direction == 3) {
                    for (int i = b; i >= t; i--) {
                        result.add(A.get(i).get(l));
                    }
                    l++;
                }
                direction += 1;
                direction %= 4;
            }
            return result;
        }
    }
}
