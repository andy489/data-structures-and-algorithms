// https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/

// Solution: Slow and Fast Pointers — O(n) time, O(1) space
var deleteMiddle = function(head) {
    if (!head.next) return null;
    let slow = head, fast = head.next.next;
    while (fast && fast.next) { slow = slow.next; fast = fast.next.next; }
    slow.next = slow.next.next;
    return head;
};
