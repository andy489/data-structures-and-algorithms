// https://leetcode.com/problems/rotate-list/

var rotateRight = function(head, k) {
    if (!head || !head.next) {
        return head;
    }
    let tail = head, len = 1;
    while (tail.next) {
        tail = tail.next;
        len++;
    }
    k %= len;
    if (k === 0) {
        return head;
    }
    let newTail = head;
    for (let i = 0; i < len - k - 1; i++) {
        newTail = newTail.next;
    }
    const newHead = newTail.next;
    newTail.next = null;
    tail.next = head;
    return newHead;
};
