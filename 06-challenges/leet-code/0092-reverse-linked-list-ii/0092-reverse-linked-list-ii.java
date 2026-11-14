// https://leetcode.com/problems/reverse-linked-list-ii/

// Solution: One-Pass In-Place Reversal — O(n) time, O(1) space
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        ListNode curr = prev.next;
        for (int i = 0; i < right - left; i++) {
            ListNode next = curr.next;
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }
        return dummy.next;
    }
}

// Solution 2: Recursion — O(n) time, O(n) space
class Solution2 {
    private ListNode tail;

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (right == 1) {
            tail = head.next;
            return head;
        }
        if (left == 1) {
            ListNode newHead = reverseBetween(head.next, 1, right - 1);
            head.next.next = head;
            head.next = tail;
            tail = head;
            return newHead;
        }
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }
}
