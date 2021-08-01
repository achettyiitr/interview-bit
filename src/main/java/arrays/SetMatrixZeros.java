package arrays;

import java.util.ArrayList;

public class SetMatrixZeros {
    public class Solution {
        public void setZeroes(ArrayList<ArrayList<Integer>> a) {
            int r = a.size();
            int c = a.get(0).size();
            int[] zr = new int[r];
            int[] zc = new int[c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (a.get(i).get(j) == 0) {
                        zr[i] = 1;
                        zc[j] = 1;
                    }
                }
            }
            for (int i = 0; i < r; i++) {
                if (zr[i] == 1) {
                    for (int j = 0; j < c; j++) {
                        a.get(i).set(j, 0);
                    }
                }
            }
            for (int i = 0; i < c; i++) {
                if (zc[i] == 1) {
                    for (int j = 0; j < r; j++) {
                        a.get(j).set(i, 0);
                    }
                }
            }
        }
    }
}
