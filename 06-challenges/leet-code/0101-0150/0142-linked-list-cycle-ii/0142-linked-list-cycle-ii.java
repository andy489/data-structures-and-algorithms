// https://leetcode.com/problems/linked-list-cycle-ii/

// Solution 1: HashSet — O(n) time, O(n) space
class Solution {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> seen = new HashSet<>();
        ListNode cur = head;
        while (cur != null) {
            if (!seen.add(cur)) return cur;
            cur = cur.next;
        }
        return null;
    }
}

// Solution 2: Floyd's Cycle Detection — O(n) time, O(1) space
class Solution2 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
