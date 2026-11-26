// https://leetcode.com/problems/reverse-nodes-in-even-length-groups/

// Solution: Linked List Manipulation — O(n) time, O(1) space
var reverseEvenLengthGroups = function(head) {
    let prev = head, groupSize = 2;
    while (prev.next) {
        let node = prev, length = 0;
        for (let i = 0; i < groupSize && node.next; i++) { node = node.next; length++; }
        if (length % 2 === 1) { prev = node; }
        else {
            let curr = prev.next, tail = curr, rev = null;
            for (let i = 0; i < length; i++) { const nxt = curr.next; curr.next = rev; rev = curr; curr = nxt; }
            prev.next = rev; tail.next = curr; prev = tail;
        }
        groupSize++;
    }
    return head;
};
