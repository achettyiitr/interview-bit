package arrays;

import java.util.ArrayList;

public class MergeIntervals {
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
        public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
            ArrayList<Interval> result = new ArrayList<>();
            int i = 0;
            while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
                result.add(intervals.get(i));
                i++;
            }
            while (i < intervals.size() && newInterval.end > intervals.get(i).start) {
                newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
                newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
                i++;
            }
            result.add(newInterval);
            while (i < intervals.size()) {
                result.add(intervals.get(i));
                i++;
            }
            return result;
        }
    }
}
