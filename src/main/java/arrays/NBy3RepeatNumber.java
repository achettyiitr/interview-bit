package arrays;

import java.util.List;

public class NBy3RepeatNumber {
    public class Solution {
        // DO NOT MODIFY THE LIST
        public int repeatedNumber(final List<Integer> a) {
            int count1 = 0, count2 = 0, one = Integer.MIN_VALUE, two = Integer.MAX_VALUE, n = a.size();
            for (int i : a) {
                if (i == one) {
                    count1++;
                } else if (i == two) {
                    count2++;
                } else if (count1 == 0) {
                    count1++;
                    one = i;
                } else if (count2 == 0) {
                    count2++;
                    two = i;
                } else {
                    count1--;
                    count2--;
                }
            }
            count1 = 0;
            count2 = 0;

            for (int i : a) {
                if (i == one)
                    count1++;
                if (i == two)
                    count2++;
            }
            if (count1 > n / 3)
                return one;
            if (count2 > n / 3)
                return two;
            return -1;
        }
    }
}
