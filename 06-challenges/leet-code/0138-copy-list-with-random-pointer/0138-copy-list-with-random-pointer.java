// https://leetcode.com/problems/copy-list-with-random-pointer/

// Solution 1: HashMap — O(n) time, O(n) space
class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> cloned = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            cloned.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            cloned.get(cur).next = cloned.get(cur.next);
            cloned.get(cur).random = cloned.get(cur.random);
            cur = cur.next;
        }
        return cloned.get(head);
    }
}

// Solution 2: Interleaving — O(n) time, O(1) space
class Solution2 {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        // Step 1: interleave clones
        Node cur = head;
        while (cur != null) {
            Node clone = new Node(cur.val);
            clone.next = cur.next;
            cur.next = clone;
            cur = clone.next;
        }
        // Step 2: set random pointers
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        // Step 3: split lists
        Node dummy = new Node(0);
        Node tail = dummy;
        cur = head;
        while (cur != null) {
            tail.next = cur.next;
            tail = tail.next;
            cur.next = cur.next.next;
            cur = cur.next;
        }
        return dummy.next;
    }
}
