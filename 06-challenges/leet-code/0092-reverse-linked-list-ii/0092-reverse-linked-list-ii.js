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
    let successor = null;
    function reverseN(node, n) {
        if (n === 1) { successor = node.next; return node; }
        const newHead = reverseN(node.next, n - 1);
        node.next.next = node;
        node.next = successor;
        return newHead;
    }
    function helper(node, lo, hi) {
        if (lo === 1) return reverseN(node, hi);
        node.next = helper(node.next, lo - 1, hi - 1);
        return node;
    }
    return helper(head, left, right);
};
