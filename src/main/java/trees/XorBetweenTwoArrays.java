package trees;

public class XorBetweenTwoArrays {
    public class Solution {
        public int solve(int[] A, int[] B) {
            TrieNode root = new TrieNode();
            for (int i: A) {
                insert(root, i);
            }
            int maxXor = 0;
            for (int i: B) {
                maxXor = Math.max(maxXor, crawlForMaxXorValue(root, i));
            }
            return maxXor;
        }

        private void insert(TrieNode root, int value) {
            TrieNode temp = root;
            for (int i = 31; i >= 0; i--) {
                int bitPosition = ((1 << i) & value) > 0 ? 1 : 0;
                if (temp.nodes[bitPosition] == null) {
                    temp.nodes[bitPosition] = new TrieNode();
                    temp = temp.nodes[bitPosition];
                } else {
                    temp = temp.nodes[bitPosition];
                }
            }
            temp.value = value;
        }

        private int crawlForMaxXorValue(TrieNode root, int value) {
            TrieNode temp = root;
            // System.out.println("crawlForMaxXorValue for value: " + value);
            for (int i = 31; i >= 0; i--) {
                int bitPosition = ((1 << i) & value) > 0 ? 1 : 0;
                int firstCheckPosition = 1 - bitPosition;
                if (temp.nodes[firstCheckPosition] != null) {
                    temp = temp.nodes[firstCheckPosition];
                } else {
                    temp = temp.nodes[bitPosition];
                }
                // System.out.println(temp + " " + temp.nodes[firstCheckPosition] + " " + temp.nodes[bitPosition]);
            }
            return temp.value ^ value;
        }


        class TrieNode {
            int value;
            TrieNode[] nodes;
            TrieNode() {
                this.value = 0;
                this.nodes = new TrieNode[2];
            }
        }
    }
}
