package twopointers;

import java.util.ArrayList;

public class MaxContinuousSeriesof1s {
    public class Solution {
        public ArrayList<Integer> maxone(ArrayList<Integer> A, int B) {
            int start = 0, end = 0, n = A.size(), count = 0, ans = 0, ansL = -1, ansR = -1;
            boolean isUsed = false;
            while (end < n) {
                if (A.get(end) == 1) {
                    count++;
                    if (count > ans) {
                        ans = count;
                        ansL = start;
                        ansR = end;
                    }
                    end++;
                } else {
                    if (B > 0) {
                        B--;
                        count++;
                        if (count > ans) {
                            ans = count;
                            ansL = start;
                            ansR = end;
                        }
                        end++;
                    } else {
                        if (A.get(start) == 0) {
                            B++;
                        }
                        start++;
                        count--;
                    }
                }
            }
            ArrayList<Integer> result = new ArrayList<>();
            if (ansL != -1 && ansR != -1) {
                for (int i = ansL; i <= ansR; i++) {
                    result.add(i);
                }
            }
            return result;
        }
    }
}
