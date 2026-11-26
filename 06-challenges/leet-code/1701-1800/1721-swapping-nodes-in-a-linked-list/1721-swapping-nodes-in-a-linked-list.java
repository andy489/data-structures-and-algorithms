// https://leetcode.com/problems/swapping-nodes-in-a-linked-list/

// Solution: Two-Pointer — O(n) time, O(1) space
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode front = head;
        for (int i = 1; i < k; i++) {
            front = front.next;
        }
        ListNode back = head, cur = front;
        while (cur.next != null) {
            cur = cur.next;
            back = back.next;
        }
        int tmp = front.val;
        front.val = back.val;
        back.val = tmp;
        return head;
    }
}
