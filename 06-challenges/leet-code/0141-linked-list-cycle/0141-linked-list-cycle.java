// https://leetcode.com/problems/linked-list-cycle/

// Solution: Floyd's Cycle Detection (Tortoise and Hare) — O(n) time, O(1) space
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}

// Solution 2: HashSet of visited nodes — O(n) time, O(n) space
class Solution2 {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        ListNode cur = head;
        while (cur != null) {
            if (!visited.add(cur)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
}

// Solution 3: Recursive with visited set — O(n) time, O(n) space (+ O(n) stack)
class Solution3 {
    public boolean hasCycle(ListNode head) {
        return detect(head, new HashSet<>());
    }

    private boolean detect(ListNode node, Set<ListNode> visited) {
        if (node == null) return false;
        if (!visited.add(node)) return true;
        return detect(node.next, visited);
    }
}
