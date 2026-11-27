// https://leetcode.com/problems/find-the-difference-of-two-arrays/
var findDifference = function (nums1, nums2) {
    const set1 = new Set(nums1);
    const set2 = new Set(nums2);
    const diff1 = [...set1].filter(n => !set2.has(n));
    const diff2 = [...set2].filter(n => !set1.has(n));
    return [diff1, diff2];
};
