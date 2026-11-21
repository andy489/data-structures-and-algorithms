// https://leetcode.com/problems/insertion-sort-list/

// Solution: Dummy head + scan — O(n^2) time, O(1) space
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode curr = head;
        ListNode prev = dummy;
        while (curr != null) {
            ListNode next = curr.next;
            if (curr.val >= prev.val) {
                prev.next = curr;
                prev = curr;
            } else {
                ListNode p = dummy;
                while (p.next.val <= curr.val) p = p.next;
                curr.next = p.next;
                p.next = curr;
            }
            curr = next;
        }
        prev.next = null;
        return dummy.next;
    }
}
