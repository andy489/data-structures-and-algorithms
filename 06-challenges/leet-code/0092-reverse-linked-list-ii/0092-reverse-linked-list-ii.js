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
