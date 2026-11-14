// https://leetcode.com/problems/partition-list/

// Solution: Two Dummy Lists — O(n) time, O(1) space
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode lessDummy = new ListNode(0);
        ListNode greaterDummy = new ListNode(0);
        ListNode less = lessDummy, greater = greaterDummy;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val < x) {
                less.next = curr;
                less = less.next;
            } else {
                greater.next = curr;
                greater = greater.next;
            }
            curr = curr.next;
        }
        greater.next = null;
        less.next = greaterDummy.next;
        return lessDummy.next;
    }
}
