// https://leetcode.com/problems/reverse-linked-list-ii/

var reverseBetween = function(head, left, right) {
    const dummy = { val: 0, next: head };
    let prev = dummy;
    for (let i = 0; i < left - 1; i++) prev = prev.next;
    let curr = prev.next;
    for (let i = 0; i < right - left; i++) {
        const next = curr.next;
        curr.next = next.next;
        next.next = prev.next;
        prev.next = next;
    }
    return dummy.next;
};

// Solution 2: Recursion — O(n) time, O(n) space
var reverseBetween2 = function(head, left, right) {
    let tail = null;
    function helper(node, lo, hi) {
        if (hi === 1) { tail = node.next; return node; }
        if (lo === 1) {
            const newHead = helper(node.next, 1, hi - 1);
            node.next.next = node;
            node.next = tail;
            tail = node;
            return newHead;
        }
        node.next = helper(node.next, lo - 1, hi - 1);
        return node;
    }
    return helper(head, left, right);
};
