package arrays;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    public class Solution {
        // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
        public String largestNumber(final int[] A) {
            String[] temp = new String[A.length];
            for (int i = 0; i < temp.length; i++) {
                temp[i] = "" + A[i];
            }
            Arrays.sort(temp, new Comparator<String>() {
                @Override
                public int compare(String a, String b) {
                    String XY = a + b;
                    String YX = b + a;
                    return XY.compareTo(YX) > 0 ? -1 : 1;
                }
            });
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < temp.length; i++) {
                if (temp[i].equals("0")) continue;
                else {
                    sb.append(temp[i]);
                }
            }
            String output = sb.toString();
            return output.length() == 0 ? "0" : output;
        }
    }
}
