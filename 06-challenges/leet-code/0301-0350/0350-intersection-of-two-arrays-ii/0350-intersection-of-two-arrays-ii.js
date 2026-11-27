// https://leetcode.com/problems/intersection-of-two-arrays-ii/

// Solution: HashMap Frequency Count — O(n + m) time, O(min(n,m)) space
var intersect = function(nums1, nums2) {
    const cloned = new Map();
    for (const n of nums1) cloned.set(n, (cloned.get(n) || 0) + 1);
    const result = [];
    for (const n of nums2) {
        const cnt = cloned.get(n) || 0;
        if (cnt > 0) {
            result.push(n);
            cloned.set(n, cnt - 1);
        }
    }
    return result;
};
