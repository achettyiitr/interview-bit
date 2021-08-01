package strings;

public class LengthOfLastWord {
    public class Solution {
        // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
        public int lengthOfLastWord(final String A) {
            int n = A.length(), i = n - 1, length = 0;
            boolean letterfound = false;
            while (i >= 0) {
                char ch = A.charAt(i);
                if (ch == ' ') {
                    if (letterfound) {
                        break;
                    } else {
                        i--;
                    }
                } else {
                    letterfound = true;
                    length++;
                    i--;
                }
            }
            return length;
        }
    }
}
