// https://leetcode.com/problems/reverse-nodes-in-even-length-groups/

// Solution: Linked List Manipulation — O(n) time, O(1) space
class Solution {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode prev = head;
        int groupSize = 2;
        while (prev.next != null) {
            ListNode node = prev, groupPrev = prev;
            int len = 0;
            for (int i = 0; i < groupSize && node.next != null; i++) {
                node = node.next;
                len++;
            }
            if (len % 2 == 1) {
                prev = node;
            } else {
                ListNode curr = groupPrev.next, nxt;
                ListNode tail = curr;
                ListNode reversed = null;
                for (int i = 0; i < len; i++) {
                    nxt = curr.next;
                    curr.next = reversed;
                    reversed = curr;
                    curr = nxt;
                }
                groupPrev.next = reversed;
                tail.next = curr;
                prev = tail;
            }
            groupSize++;
        }
        return head;
    }
}
