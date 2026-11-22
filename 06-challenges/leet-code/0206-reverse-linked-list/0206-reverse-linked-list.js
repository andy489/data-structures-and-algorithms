// https://leetcode.com/problems/reverse-linked-list/

// Solution: Iterative — O(n) time, O(1) space
var reverseList = function(head) {
    let prev = null;
    let curr = head;

    while (curr !== null) {
        const next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }

    return prev;
};

// Solution 2: Recursive — O(n) time, O(n) space
var reverseList2 = function(head) {
    if (head === null || head.next === null) {
        return head;
    }

    const newHead = reverseList2(head.next);
    head.next.next = head;
    head.next = null;

    return newHead;
};
