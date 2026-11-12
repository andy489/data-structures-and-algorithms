// https://leetcode.com/problems/intersection-of-two-linked-lists/

// Solution: Two-pointer path equalisation — O(m + n) time, O(1) space
var getIntersectionNode = function(headA, headB) {
    let pa = headA, pb = headB;
    while (pa !== pb) {
        pa = pa === null ? headB : pa.next;
        pb = pb === null ? headA : pb.next;
    }
    return pa;
};
