// https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/
var pairSum = function(head) {
    // Find middle
    let slow = head, fast = head;
    while (fast && fast.next) {
        slow = slow.next;
        fast = fast.next.next;
    }
    // Reverse second half
    let prev = null, curr = slow;
    while (curr) {
        let next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }
    // Compute max twin sum
    let max = 0;
    let left = head, right = prev;
    while (right) {
        max = Math.max(max, left.val + right.val);
        left = left.next;
        right = right.next;
    }
    return max;
};
