package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MergeOverlappingIntervals {
    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public class Solution {
        public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
            Collections.sort(intervals, new Comparator<Interval>() {
                @Override
                public int compare(Interval a, Interval b) {
                    return Integer.compare(a.start, b.start);
                }
            });

            ArrayList<Interval> result = new ArrayList<>();
            int i = 1, j = 0, n = intervals.size();
            while (i < n) {
                while (i < n && intervals.get(i).start <= intervals.get(j).end) {
                    intervals.get(j).end = Math.max(intervals.get(j).end, intervals.get(i).end);
                    i++;
                }
                result.add(intervals.get(j));
                j = i;
                i++;
            }
            if (j < n) result.add(intervals.get(j));
            return result;
        }
    }

}
