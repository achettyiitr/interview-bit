package backtracking;

import java.util.ArrayList;

public class PalindromePartitioning {
    public class Solution {
        public ArrayList<ArrayList<String>> partition(String a) {
            ArrayList<ArrayList<String>> results = new ArrayList<>();
            solve(a, results, new ArrayList<>());
            return results;
        }

        private void solve(String a, ArrayList<ArrayList<String>> results, ArrayList<String> temp) {
            if (a.length() == 0) {
                results.add(new ArrayList<>(temp));
                return;
            }

            for (int i = 0; i < a.length(); i++) {
                String prefix = a.substring(0, i + 1);
                String suffix = a.substring(i + 1);
                if (isPalindrome(prefix)) {
                    temp.add(prefix);
                    solve(suffix, results, temp);
                    temp.remove(temp.size() - 1);
                }
            }
        }

        private boolean isPalindrome(String str) {
            int i = 0, j = str.length() - 1;
            while (i < j) {
                if (str.charAt(i) != str.charAt(j)) return false;
                i++;
                j--;
            }
            return true;
        }
    }

}
