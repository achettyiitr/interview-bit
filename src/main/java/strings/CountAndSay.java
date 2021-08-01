package strings;

public class CountAndSay {
    public class Solution {
        public String countAndSay(int A) {
            if (A == 0) return "0";
            if (A == 1) return "1";
            StringBuilder sb = new StringBuilder("");
            sb.append("1");
            for (int i = 2; i <= A; i++) {
                String temp = sb.toString();
                sb = new StringBuilder("");
                int count = 1;
                int j = 1;
                while (j < temp.length()) {
                    if (temp.charAt(j) == temp.charAt(j - 1)) {
                        count++;
                    } else {
                        sb.append(count);
                        sb.append(temp.charAt(j - 1));
                        count = 1;
                    }
                    j++;
                }
                sb.append(count);
                sb.append(temp.charAt(j - 1));
            }
            return sb.toString();
        }
    }
}
