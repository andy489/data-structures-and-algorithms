// https://leetcode.com/problems/swap-nodes-in-pairs/

// Solution: Iterative (Dummy Head) — O(n) time, O(1) space
var swapPairs = function(head) {
    const dummy = new ListNode(0);
    dummy.next = head;
    let prev = dummy;

    while (prev.next !== null && prev.next.next !== null) {
        const first = prev.next;
        const second = prev.next.next;

        first.next = second.next;
        second.next = first;
        prev.next = second;

        prev = first;
    }

    return dummy.next;
};

// Solution2: Recursive — O(n) time, O(n) space
var swapPairs2 = function(head) {
    if (head === null || head.next === null) return head;

    const second = head.next;
    head.next = swapPairs2(second.next);
    second.next = head;

    return second;
};
