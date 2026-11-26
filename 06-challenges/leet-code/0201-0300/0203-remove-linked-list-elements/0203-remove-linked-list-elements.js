// https://leetcode.com/problems/remove-linked-list-elements/

// Solution: Sentinel Node — O(n) time, O(1) space
var removeElements = function(head, val) {
    const sentinel = new ListNode(0, head);
    let curr = sentinel;

    while (curr.next !== null) {
        if (curr.next.val === val) {
            curr.next = curr.next.next;
        } else {
            curr = curr.next;
        }
    }

    return sentinel.next;
};
