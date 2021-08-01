package strings;

import java.util.ArrayList;
import java.util.List;

public class ValidIpAddresses {
    public class Solution {
        public ArrayList<String> restoreIpAddresses(String A) {
            ArrayList<String> result = new ArrayList<>();
            dfs(A, result, 0, new int[] {0, 0, 0, 0});
            return result;
        }

        private void dfs(String A, List<String> result, int index, int[] ips) {
            if (index == ips.length) {
                if (A.length() != 0) {
                    return;
                }
                StringBuilder sb = new StringBuilder("");
                for (int i: ips) {
                    sb.append(i);
                    sb.append('.');
                }
                result.add(sb.substring(0, sb.length() - 1));
                return;
            }
            for (int i = 0; i < Math.min(3, A.length()); i++) {
                String prefix = A.substring(0, i + 1);
                String suffix = A.substring(i + 1);
                if (isValid(prefix)) {
                    ips[index] = Integer.parseInt(prefix);
                    dfs(suffix, result, index + 1, ips);
                }
            }
        }

        private boolean isValid(String str) {
            if (str == null || str.length() == 0) return false;
            if (str.charAt(0) == '0' && str.length() > 1) return false;
            int val = Integer.parseInt(str);
            if (val < 0 || val > 255) return false;
            return true;
        }
    }
}
