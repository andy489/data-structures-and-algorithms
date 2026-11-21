// https://leetcode.com/problems/insertion-sort-list/

// Solution: Dummy head + scan — O(n^2) time, O(1) space
var insertionSortList = function(head) {
    const dummy = { val: -Infinity, next: null };
    let curr = head, prev = dummy;
    while (curr) {
        const next = curr.next;
        if (curr.val >= prev.val) {
            prev.next = curr;
            prev = curr;
        } else {
            let p = dummy;
            while (p.next.val <= curr.val) p = p.next;
            curr.next = p.next;
            p.next = curr;
        }
        curr = next;
    }
    prev.next = null;
    return dummy.next;
};
