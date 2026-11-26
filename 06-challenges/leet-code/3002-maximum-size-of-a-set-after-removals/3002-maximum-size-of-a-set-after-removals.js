// https://leetcode.com/problems/maximum-size-of-a-set-after-removals/

var maximumSetSize = function(nums1, nums2) {
    const s1 = new Set(nums1), s2 = new Set(nums2);
    const n = nums1.length, half = n / 2;
    let only1 = 0, only2 = 0, shared = 0;
    for (const x of s1) { if (s2.has(x)) shared++; else only1++; }
    for (const x of s2) { if (!s1.has(x)) only2++; }
    const take1 = Math.min(only1, half), take2 = Math.min(only2, half);
    return take1 + take2 + Math.min(shared, n - take1 - take2);
};
