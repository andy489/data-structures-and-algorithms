// https://leetcode.com/problems/merge-in-between-linked-lists/

// Solution: Two Pointer Traversal — O(n + m) time, O(1) space
class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode nodeBeforeA = list1;
        for (int i = 0; i < a - 1; i++) {
            nodeBeforeA = nodeBeforeA.next;
        }
        ListNode nodeAfterB = nodeBeforeA;
        for (int i = 0; i <= b - a + 1; i++) {
            nodeAfterB = nodeAfterB.next;
        }
        nodeBeforeA.next = list2;
        ListNode tail = list2;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = nodeAfterB;
        return list1;
    }
}
