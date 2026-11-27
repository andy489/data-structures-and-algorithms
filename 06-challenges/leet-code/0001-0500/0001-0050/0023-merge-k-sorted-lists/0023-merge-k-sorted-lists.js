// https://leetcode.com/problems/merge-k-sorted-lists/

// Solution: Min-Heap (Priority Queue) — O(N log k) time, O(k) space
var mergeKLists = function(lists) {
    const dummy = new ListNode(0);
    let curr = dummy;

    // Min-heap simulation using sorted insertion (JS has no built-in heap)
    const heap = [];
    for (const node of lists) {
        if (node !== null) {
            heap.push(node);
        }
    }
    heap.sort((a, b) => a.val - b.val);

    const push = (node) => {
        let lo = 0, hi = heap.length;
        while (lo < hi) {
            const mid = (lo + hi) >>> 1;
            if (heap[mid].val <= node.val) { lo = mid + 1; } else { hi = mid; }
        }
        heap.splice(lo, 0, node);
    };

    while (heap.length > 0) {
        const node = heap.shift();
        curr.next = node;
        curr = curr.next;
        if (node.next !== null) {
            push(node.next);
        }
    }

    return dummy.next;
};

// Solution2: Divide and Conquer — O(N log k) time, O(log k) space
var mergeKLists2 = function(lists) {
    if (lists.length === 0) { return null; }
    return mergeRange(lists, 0, lists.length - 1);
};

function mergeRange(lists, lo, hi) {
    if (lo === hi) { return lists[lo]; }
    const mid = (lo + hi) >>> 1;
    const left = mergeRange(lists, lo, mid);
    const right = mergeRange(lists, mid + 1, hi);
    return mergeTwoLists(left, right);
}

function mergeTwoLists(l1, l2) {
    const dummy = new ListNode(0);
    let curr = dummy;
    while (l1 !== null && l2 !== null) {
        if (l1.val <= l2.val) {
            curr.next = l1;
            l1 = l1.next;
        } else {
            curr.next = l2;
            l2 = l2.next;
        }
        curr = curr.next;
    }
    curr.next = l1 !== null ? l1 : l2;
    return dummy.next;
}
