package strings;

import java.math.BigInteger;

public class CompareVersionNumbers {
    public class Solution {
        public int compareVersion(String A, String B) {
            int i = 0, j = 0;
            BigInteger v1 = BigInteger.ZERO, v2 = BigInteger.ZERO;
            while (i < A.length() || j < B.length()) {
                while (i < A.length() && A.charAt(i) != '.') {
                    v1 = v1.multiply(BigInteger.valueOf(10)).add(BigInteger.valueOf(Character.getNumericValue(A.charAt(i))));
                    i++;
                }
                while (j < B.length() && B.charAt(j) != '.') {
                    v2 = v2.multiply(BigInteger.valueOf(10)).add(BigInteger.valueOf(Character.getNumericValue(B.charAt(j))));
                    j++;
                }
                // System.out.println(v1.toString());
                // System.out.println(v2.toString());
                int compare = v1.compareTo(v2);
                if (compare == 1) return 1;
                if (compare == -1) return -1;

                i++;
                j++;
                v1 = BigInteger.ZERO;
                v2 = BigInteger.ZERO;
            }
            return 0;
        }
    }
}
