package trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ShortestUniquePrefix {
    public class Solution {
        public ArrayList<String> prefix(ArrayList<String> A) {
            TrieNode root = new TrieNode();
            for (String s: A) {
                insert(root, s);
            }
            ArrayList<String> result = new ArrayList<>();
            for (String s: A) {
                int length = crawl(root, s);
                result.add(s.substring(0, length));
            }
            return result;
        }

        private void insert(TrieNode root, String s) {
            TrieNode temp = root;
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (temp.map.containsKey(ch)) {
                    temp = temp.map.get(ch);
                } else {
                    temp.map.put(ch, new TrieNode());
                    temp = temp.map.get(ch);
                }
                temp.count++;
            }
            temp.isEnd = true;
        }

        private int crawl(TrieNode root, String s) {
            TrieNode temp = root;
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                temp = temp.map.get(ch);
                if (temp.count == 1) {
                    return i + 1;
                } else {
                    continue;
                }
            }
            return s.length();
        }

        class TrieNode {
            Map<Character, TrieNode> map = new HashMap<>();
            boolean isEnd = false;
            int count = 0;
        }
    }
}
