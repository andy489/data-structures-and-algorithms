// https://leetcode.com/problems/copy-list-with-random-pointer/

// Solution 1: HashMap — O(n) time, O(n) space
var copyRandomList = function(head) {
    const cloned = new Map();
    let cur = head;
    while (cur) { cloned.set(cur, new Node(cur.val)); cur = cur.next; }
    cur = head;
    while (cur) {
        cloned.get(cur).next = cloned.get(cur.next) ?? null;
        cloned.get(cur).random = cloned.get(cur.random) ?? null;
        cur = cur.next;
    }
    return cloned.get(head) ?? null;
};

// Solution 2: Interleaving — O(n) time, O(1) space
var copyRandomList2 = function(head) {
    if (!head) return null;
    let cur = head;
    while (cur) {
        const clone = new Node(cur.val);
        clone.next = cur.next;
        cur.next = clone;
        cur = clone.next;
    }
    cur = head;
    while (cur) {
        if (cur.random) cur.next.random = cur.random.next;
        cur = cur.next.next;
    }
    const dummy = new Node(0);
    let tail = dummy;
    cur = head;
    while (cur) {
        tail.next = cur.next;
        tail = tail.next;
        cur.next = cur.next.next;
        cur = cur.next;
    }
    return dummy.next;
};
