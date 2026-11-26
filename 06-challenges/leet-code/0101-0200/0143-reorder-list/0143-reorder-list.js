// https://leetcode.com/problems/reorder-list/

// Solution 1: Find Middle + Reverse + Merge — O(n) time, O(1) space
var reorderList = function(head) {
    if (!head || !head.next) return;

    let slow = head, fast = head;
    while (fast.next && fast.next.next) {
        slow = slow.next;
        fast = fast.next.next;
    }

    let second = slow.next;
    slow.next = null;
    second = reverse(second);

    let first = head;
    while (second) {
        const tmp1 = first.next;
        const tmp2 = second.next;
        first.next = second;
        second.next = tmp1;
        first = tmp1;
        second = tmp2;
    }
};

function reverse(head) {
    let prev = null, cur = head;
    while (cur) {
        const nxt = cur.next;
        cur.next = prev;
        prev = cur;
        cur = nxt;
    }
    return prev;
}

// Solution 2: Deque (Array as deque) — O(n) time, O(n) space
var reorderList2 = function(head) {
    if (!head || !head.next) return;

    const nodes = [];
    let cur = head;
    while (cur) {
        nodes.push(cur);
        cur = cur.next;
    }

    let lo = 0, hi = nodes.length - 1;
    while (lo < hi) {
        nodes[lo].next = nodes[hi];
        lo++;
        if (lo === hi) break;
        nodes[hi].next = nodes[lo];
        hi--;
    }
    nodes[lo].next = null;
};
