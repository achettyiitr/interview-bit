package strings;

public class ReverseTheString {
    public class Solution {
        public String solve(String A) {
            StringBuilder sb = new StringBuilder("");
            char[] arr = A.toCharArray();
            int lastPosition = 0;
            for (int i = 0; i < A.length(); i++) {
                char ch = A.charAt(i);
                if (ch == ' ') {
                    reverse(arr, lastPosition, i - 1);
                    lastPosition = i + 1;
                } else {
                    continue;
                }
            }
            reverse(arr, lastPosition, A.length() - 1);
            reverse(arr, 0, A.length() - 1);

            int i = 0, j = arr.length - 1;
            while (i < arr.length && arr[i] == ' ') i++;
            while (j >= 0 && arr[j] == ' ') j--;
            for (int k = i; k <= j; ) {
                if (arr[k] == ' ') {
                    if (k < j && arr[k + 1] == ' ') {
                        while (k <= j && arr[k] == ' ') k++;
                        sb.append(' ');
                    } else {
                        sb.append(arr[k++]);
                    }
                } else {
                    sb.append(arr[k++]);
                }
            }

            return sb.toString();
        }

        private void reverse(char[] arr, int i, int j) {
            while (i < j) {
                char ch = arr[i];
                arr[i] = arr[j];
                arr[j] = ch;
                i++;
                j--;
            }
        }
    }
}
