package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LetterPhone {
    public class Solution {
        public ArrayList<String> letterCombinations(String A) {
            Map<Character, String> map = new HashMap<>();
            map.put('0', "0");
            map.put('1', "1");
            map.put('2', "abc");
            map.put('3', "def");
            map.put('4', "ghi");
            map.put('5', "jkl");
            map.put('6', "mno");
            map.put('7', "pqrs");
            map.put('8', "tuv");
            map.put('9', "wxyz");

            ArrayList<String> result = new ArrayList<>();
            result.add("");

            return solve(A, 0, map, result);
        }

        private ArrayList<String> solve(String s, int index, Map<Character, String> map, ArrayList<String> temp) {
            if (index == s.length()) {
                return temp;
            }
            ArrayList<String> ntemp = new ArrayList<>();
            char ch = s.charAt(index);
            String data = map.get(ch);
            for (int i = 0; i < temp.size(); i++) {
                String tdata = temp.get(i);
                for (int j = 0; j < data.length(); j++) {
                    ntemp.add(tdata + data.charAt(j));
                }
            }
            return solve(s, index + 1, map, ntemp);
        }
    }
}
