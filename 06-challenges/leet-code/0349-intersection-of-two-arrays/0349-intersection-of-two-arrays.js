// https://leetcode.com/problems/intersection-of-two-arrays/

// Solution: HashSet — O(n + m) time, O(n) space
var intersection = function(nums1, nums2) {
    const set1 = new Set(nums1);
    const result = new Set();
    for (const n of nums2) {
        if (set1.has(n)) result.add(n);
    }
    return [...result];
};
