// https://leetcode.com/problems/sort-list/

// Solution 1: Top-down merge sort — O(n log n) time, O(log n) space
var sortList = function(head) {
    if (!head || !head.next) return head;
    let slow = head, fast = head.next;
    while (fast && fast.next) { slow = slow.next; fast = fast.next.next; }
    const mid = slow.next;
    slow.next = null;
    return merge(sortList(head), sortList(mid));
};

function merge(l1, l2) {
    const dummy = { val: 0, next: null };
    let curr = dummy;
    while (l1 && l2) {
        if (l1.val <= l2.val) { curr.next = l1; l1 = l1.next; }
        else { curr.next = l2; l2 = l2.next; }
        curr = curr.next;
    }
    curr.next = l1 || l2;
    return dummy.next;
}

// Solution 2: Bottom-up merge sort — O(n log n) time, O(1) space
var sortList2 = function(head) {
    let n = 0;
    for (let x = head; x; x = x.next) n++;
    const dummy = { val: 0, next: head };
    for (let size = 1; size < n; size <<= 1) {
        let curr = dummy.next, tail = dummy;
        while (curr) {
            const left = curr;
            const right = split(left, size);
            curr = split(right, size);
            const [h, t] = mergeWithTail(left, right);
            tail.next = h; tail = t;
        }
    }
    return dummy.next;
};

function split(head, n) {
    for (let i = 1; i < n && head; i++) head = head.next;
    if (!head) return null;
    const rest = head.next; head.next = null; return rest;
}

function mergeWithTail(l1, l2) {
    const dummy = { val: 0, next: null };
    let curr = dummy;
    while (l1 && l2) {
        if (l1.val <= l2.val) { curr.next = l1; l1 = l1.next; }
        else { curr.next = l2; l2 = l2.next; }
        curr = curr.next;
    }
    curr.next = l1 || l2;
    while (curr.next) curr = curr.next;
    return [dummy.next, curr];
}
