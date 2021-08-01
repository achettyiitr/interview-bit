package strings;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonPrefix {
    public class Solution {
        public String longestCommonPrefix(String[] A) {
            StringBuilder sb = new StringBuilder("");
            TrieNode root = new TrieNode();
            for (int i = 0; i < A.length; i++) {
                insert(root, A[i]);
            }
            crawl(root, sb);
            return sb.toString();
        }

        private void insert(TrieNode root, String s) {
            TrieNode temp = root;
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (temp.map.get(ch) == null) {
                    temp.map.put(ch, new TrieNode());
                }
                temp = temp.map.get(ch);
            }
            temp.isEnd = true;
        }

        private void crawl(TrieNode root, StringBuilder sb) {
            TrieNode temp = root;
            while (!temp.isEnd) {
                if (temp.map.size() == 1) {
                    for (Map.Entry<Character, TrieNode> entry: temp.map.entrySet()) {
                        sb.append(entry.getKey());
                        temp = entry.getValue();
                    }
                } else {
                    break;
                }
            }
        }

        class TrieNode {
            boolean isEnd;
            Map<Character, TrieNode> map;
            TrieNode() {
                this.map = new HashMap<>();
                this.isEnd = false;
            }
        }
    }
}
