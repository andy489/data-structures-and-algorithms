// https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/

// Solution: Iterative with Stack — O(n) time, O(n) space
class Solution {
    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(head);
        Node prev = null;

        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            if (prev != null) {
                prev.next = curr;
                curr.prev = prev;
            }
            if (curr.next != null) {
                stack.push(curr.next);
            }
            if (curr.child != null) {
                stack.push(curr.child);
                curr.child = null;
            }
            prev = curr;
        }
        return head;
    }
}

// Solution 2: Recursive — O(n) time, O(d) space
class Solution2 {
    public Node flatten(Node head) {
        Node curr = head;
        while (curr != null) {
            if (curr.child != null) {
                Node child = curr.child;
                Node next = curr.next;
                curr.next = child;
                child.prev = curr;
                curr.child = null;
                // find tail of child list
                Node tail = child;
                while (tail.next != null) {
                    tail = tail.next;
                }
                tail.next = next;
                if (next != null) {
                    next.prev = tail;
                }
            }
            curr = curr.next;
        }
        return head;
    }
}
