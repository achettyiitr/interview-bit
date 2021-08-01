package hashing;

import java.util.HashMap;
import java.util.Map;

public class CopyList {
    class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }

    ;
    public class Solution {
        public RandomListNode copyRandomList(RandomListNode head) {
            Map<RandomListNode, RandomListNode> map = new HashMap<>();
            RandomListNode temp = head;
            while (temp != null) {
                RandomListNode node = new RandomListNode(temp.label);
                map.put(temp, node);
                temp = temp.next;
            }
            temp = head;
            while (temp != null) {
                map.get(temp).next = map.get(temp.next);
                map.get(temp).random = map.get(temp.random);
                temp = temp.next;
            }

            return map.get(head);
        }
    }

}
