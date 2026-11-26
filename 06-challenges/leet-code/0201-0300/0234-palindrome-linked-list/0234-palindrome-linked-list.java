// https://leetcode.com/problems/palindrome-linked-list/

// Solution: Find Middle + Reverse Second Half — O(n) time, O(1) space
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = reverse(slow);
        ListNode curr = secondHalf;
        ListNode left = head;

        while (curr != null) {
            if (left.val != curr.val) {
                return false;
            }
            left = left.next;
            curr = curr.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
