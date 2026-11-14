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
