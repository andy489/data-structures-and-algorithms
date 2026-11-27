// https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/
class Solution {
    public int pairSum(ListNode head) {
        // Find middle
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // Reverse second half
        ListNode prev = null, curr = slow;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // Compute max twin sum
        int max = 0;
        ListNode left = head, right = prev;
        while (right != null) {
            max = Math.max(max, left.val + right.val);
            left = left.next;
            right = right.next;
        }
        return max;
    }
}
