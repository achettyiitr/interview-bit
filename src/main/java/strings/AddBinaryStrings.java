package strings;

public class AddBinaryStrings {
    public class Solution {
        public String addBinary(String A, String B) {
            int len1 = A.length();
            int len2 = B.length();
            int i = len1 - 1, j = len2 - 1, c = 0;
            StringBuilder sb = new StringBuilder("");
            while (i >= 0 && j >= 0) {
                int val1 = Character.getNumericValue(A.charAt(i--));
                int val2 = Character.getNumericValue(B.charAt(j--));
                int sum = val1 + val2 + c;
                c = sum / 2;
                sb.append(sum % 2);
            }
            while (i >= 0) {
                int val1 = Character.getNumericValue(A.charAt(i--));
                int sum = val1 + c;
                c = sum / 2;
                sb.append(sum % 2);
            }
            while (j >= 0) {
                int val2 = Character.getNumericValue(B.charAt(j--));
                int sum = val2 + c;
                c = sum / 2;
                sb.append(sum % 2);
            }
            if (c == 1) {
                sb.append(1);
            }
            return sb.reverse().toString();
        }
    }
}
