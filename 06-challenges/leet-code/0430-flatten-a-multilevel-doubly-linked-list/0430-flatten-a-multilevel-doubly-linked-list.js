// https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/

var flatten = function(head) {
    let curr = head;
    while (curr) {
        if (curr.child) {
            const child = curr.child;
            const next = curr.next;
            curr.next = child;
            child.prev = curr;
            curr.child = null;
            let tail = child;
            while (tail.next) {
                tail = tail.next;
            }
            tail.next = next;
            if (next) {
                next.prev = tail;
            }
        }
        curr = curr.next;
    }
    return head;
};
