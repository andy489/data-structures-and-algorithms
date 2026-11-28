// https://leetcode.com/problems/minimum-operations-to-maximize-last-elements-in-arrays/

var minOperations = function(nums1, nums2) {
    const n = nums1.length;
    const a = nums1[n - 1];
    const b = nums2[n - 1];

    function count(ta, tb) {
        let swaps = 0;
        for (let i = 0; i < n - 1; i++) {
            if (nums1[i] <= ta && nums2[i] <= tb) {
                // no swap
            } else if (nums2[i] <= ta && nums1[i] <= tb) {
                swaps++;
            } else {
                return -1;
            }
        }
        return swaps;
    }

    const op1 = count(a, b);
    const op2 = count(b, a);
    if (op1 === -1 && op2 === -1) return -1;
    if (op1 === -1) return op2 + 1;
    if (op2 === -1) return op1;
    return Math.min(op1, op2 + 1);
};
