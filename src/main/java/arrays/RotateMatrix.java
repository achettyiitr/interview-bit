package arrays;

import java.util.ArrayList;

public class RotateMatrix {
    public class Solution {
        public void rotate(ArrayList<ArrayList<Integer>> A) {
            int n = A.size();
            for (int i = 0; i < n / 2; i++) {
                for (int j = 0; j < (n + 1) / 2; j++) {
                    int temp = A.get(i).get(j);
                    A.get(i).set(j, A.get(n - 1 - j).get(i));
                    A.get(n - 1 - j).set(i, A.get(n - 1 - i).get(n - 1 - j));
                    A.get(n - 1 - i).set(n - 1 - j, A.get(j).get(n - 1 - i));
                    A.get(j).set(n - 1 - i, temp);
                }
            }
        }
    }
}
