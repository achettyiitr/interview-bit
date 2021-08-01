package backtracking;

import java.util.ArrayList;
import java.util.Collections;

public class GrayCode {
    public class Solution {
        public ArrayList<Integer> grayCode(int a) {
            ArrayList<Integer> codes = new ArrayList<>();
            grayCodeUtil(a).forEach(s -> {
                codes.add(Integer.parseInt(s, 2));
            });
            return codes;
        }

        private ArrayList<String> grayCodeUtil(int a) {
            ArrayList<String> codes = new ArrayList<>();
            if (a == 0) return codes;
            codes.add("0");
            codes.add("1");

            for (int i = 2; i <= a; i++) {
                ArrayList<String> ncodes = new ArrayList<>();
                codes.forEach(s -> ncodes.add("0" + s));
                Collections.reverse(codes);
                codes.forEach(s -> ncodes.add("1" + s));
                codes = ncodes;
            }
            return codes;
        }
    }
}
