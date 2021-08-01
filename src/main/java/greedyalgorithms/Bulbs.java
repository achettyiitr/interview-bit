package greedyalgorithms;

import java.util.ArrayList;

public class Bulbs {
    public class Solution {
        public int bulbs(ArrayList<Integer> A) {
            int count = 0;
            int switchvalue = 0;
            for (int i: A) {
                if (i == switchvalue) {
                    count++;
                    switchvalue = 1 - switchvalue;
                } else {
                    continue;
                }
            }
            return count;
        }
    }
}
