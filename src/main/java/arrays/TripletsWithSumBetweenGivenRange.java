package arrays;

public class TripletsWithSumBetweenGivenRange {
    public class Solution {
        public int solve(String[] A) {
            double a = Double.parseDouble(A[0]);
            double b = Double.parseDouble(A[1]);
            double c = Double.parseDouble(A[2]);

            for (int i = 3; i < A.length; i++) {
                double s = a + b + c;

                double min = Math.min(a, Math.min(b, c));
                double max = Math.max(a, Math.min(b, c));
                double val = Double.parseDouble(A[i]);

                if (s > 1.00 && s < 2.00) return 1;
                else if (s < 1.00) {
                    if (a < b && a < c) {
                        a = val;
                    } else if (b < a && b < c) {
                        b = val;
                    } else {
                        c = val;
                    }
                }
                else if (s > 2.00) {
                    if (a > b && a > c) {
                        a = val;
                    } else if (b > a && b > c) {
                        b = val;
                    } else {
                        c = val;
                    }
                }
            }
            double s = a + b + c;
            if (s > 1.00 && s < 2.00) return 1;
            else return 0;
        }
    }
}
