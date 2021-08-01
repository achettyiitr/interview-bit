package strings;

public class MultiplyStrings {
    public class Solution {
        public String multiply(String A, String B) {
            int l1 = A.length();
            int l2 = B.length();
            int[] res = new int[l1 + l2];
            for (int i = l2 - 1; i >= 0; i--) {
                char ch1 = B.charAt(i);
                int v1 = Character.getNumericValue(ch1);
                int carry = 0;
                for (int j = l1 - 1; j >= 0; j--) {
                    char ch2 = A.charAt(j);
                    int v2 = Character.getNumericValue(ch2);
                    int sum = v1 * v2 + carry + res[i + j + 1];
                    carry = sum / 10;
                    res[i + j + 1] = sum % 10;
                }
                res[i] = carry;
            }
            StringBuilder sb = new StringBuilder("");
            int i = 0;
            while (i < res.length && res[i] == 0) i++;
            while (i < res.length) {
                sb.append(res[i]);
                i++;
            }
            String output = sb.toString();
            return output.length() == 0 ? "0" : output;
        }
    }
}
