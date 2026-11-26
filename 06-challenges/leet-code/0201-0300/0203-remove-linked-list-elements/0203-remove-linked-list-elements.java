// https://leetcode.com/problems/remove-linked-list-elements/

// Solution: Sentinel Node — O(n) time, O(1) space
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode sentinel = new ListNode(0, head);
        ListNode curr = sentinel;

        while (curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        return sentinel.next;
    }
}
