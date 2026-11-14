// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/

// Solution: Sentinel + One Pass — O(n) time, O(1) space
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        while (prev.next != null) {
            if (prev.next.next != null && prev.next.val == prev.next.next.val) {
                int val = prev.next.val;
                ListNode curr = prev.next;
                while (curr != null && curr.val == val) {
                    curr = curr.next;
                }
                prev.next = curr;
            } else {
                prev = prev.next;
            }
        }
        return dummy.next;
    }
}
