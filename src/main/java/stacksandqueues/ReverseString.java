package stacksandqueues;

public class ReverseString {
    public class Solution {
        public String reverseString(String A) {
            char arr[] = A.toCharArray();;
            int start = 0, end = A.length() - 1;
            while (start < end) {
                char ch = arr[start];
                arr[start] = arr[end];
                arr[end] = ch;
                start++;
                end--;
            }
            return new String(arr);
        }
    }
}
