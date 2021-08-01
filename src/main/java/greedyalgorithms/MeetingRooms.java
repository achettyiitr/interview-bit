package greedyalgorithms;

import java.util.ArrayList;
import java.util.Arrays;

public class MeetingRooms {
    public class Solution {
        public int solve(ArrayList<ArrayList<Integer>> A) {
            int count = 0, maxcount = 0;
            int i = 0, j =0;
            int n = A.size();
            int start[] = new int[n], end[] = new int[n];
            while (i < n) {
                end[i] = A.get(i).get(1);
                start[i] = A.get(i).get(0);
                i++;
            }
            i = 0;
            Arrays.sort(start);
            Arrays.sort(end);
            while(i < n && j < n) {
                if (start[i] < end[j]) {
                    count++;
                    i++;
                } else {
                    count--;
                    j++;
                }
                maxcount = Math.max(maxcount, count);
            }
            return maxcount;
        }
    }
}
