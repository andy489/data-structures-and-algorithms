// https://leetcode.com/problems/reverse-nodes-in-k-group/

// Solution: Iterative (Dummy Head) — O(n) time, O(1) space
var reverseKGroup = function(head, k) {
    const dummy = new ListNode(0);
    dummy.next = head;
    let prev = dummy;

    while (true) {
        const kth = getKth(prev, k);
        if (!kth) break;

        const nextGroup = kth.next;
        let curr = prev.next;

        while (curr !== nextGroup) {
            const nxt = curr.next;
            curr.next = kth.next;
            kth.next = curr;
            curr = nxt;
        }

        const tail = prev.next;
        prev.next = kth;
        prev = tail;
    }

    return dummy.next;
};

function getKth(curr, k) {
    while (curr !== null && k > 0) {
        curr = curr.next;
        k--;
    }
    return curr;
}

// Solution2: Recursive — O(n) time, O(n/k) space
var reverseKGroup2 = function(head, k) {
    let kth = head;
    let count = 0;
    while (kth !== null && count < k) {
        kth = kth.next;
        count++;
    }
    if (count < k) return head;

    let prev = null;
    let curr = head;
    while (curr !== kth) {
        const nxt = curr.next;
        curr.next = prev;
        prev = curr;
        curr = nxt;
    }

    head.next = reverseKGroup2(kth, k);
    return prev;
};
