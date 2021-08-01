package twopointers;

import java.util.ArrayList;
import java.util.Collections;

public class SortByColor {
    public class Solution {
        public void sortColors(ArrayList<Integer> a) {
            int i = 0, j = 0, k = a.size() - 1;
            while (j <= k) {
                switch(a.get(j)) {
                    case 0: {
                        Collections.swap(a, i, j);
                        i++;
                        j++;
                        break;
                    }
                    case 1: {
                        j++;
                        break;
                    }
                    case 2: {
                        Collections.swap(a, j, k);
                        k--;
                    }
                }
            }
        }
    }
}
