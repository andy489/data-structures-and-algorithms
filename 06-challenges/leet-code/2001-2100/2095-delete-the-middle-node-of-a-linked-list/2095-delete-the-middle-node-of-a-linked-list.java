// https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/

// Solution: Slow and Fast Pointers — O(n) time, O(1) space
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) { return null; }
        ListNode slow = head, fast = head.next.next;
        while (fast != null && fast.next != null) { slow = slow.next; fast = fast.next.next; }
        slow.next = slow.next.next;
        return head;
    }
}
