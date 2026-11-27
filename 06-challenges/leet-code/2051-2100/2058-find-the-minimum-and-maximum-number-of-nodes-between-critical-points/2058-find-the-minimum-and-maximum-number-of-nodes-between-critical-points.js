// https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/

// Solution: Linear Scan — O(n) time, O(1) space
var nodesBetweenCriticalPoints = function(head) {
    let firstCrit = -1, prevCrit = -1, minDist = Infinity, idx = 1;
    let prev = head, curr = head.next;
    while (curr.next) {
        if ((curr.val > prev.val && curr.val > curr.next.val) ||
            (curr.val < prev.val && curr.val < curr.next.val)) {
            if (prevCrit !== -1) minDist = Math.min(minDist, idx - prevCrit);
            if (firstCrit === -1) firstCrit = idx;
            prevCrit = idx;
        }
        prev = curr; curr = curr.next; idx++;
    }
    if (firstCrit === prevCrit) return [-1, -1];
    return [minDist, prevCrit - firstCrit];
};
