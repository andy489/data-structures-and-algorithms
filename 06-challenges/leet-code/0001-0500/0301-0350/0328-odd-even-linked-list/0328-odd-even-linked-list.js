// https://leetcode.com/problems/odd-even-linked-list/

// Solution: Two Pointers (In-Place) — O(n) time, O(1) space
var oddEvenList = function(head) {
    if (!head) return null;
    let odd = head, even = head.next, evenHead = even;
    while (even && even.next) {
        odd.next = even.next;
        odd = odd.next;
        even.next = odd.next;
        even = even.next;
    }
    odd.next = evenHead;
    return head;
};
