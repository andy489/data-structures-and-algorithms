// https://leetcode.com/problems/minimum-cost-to-equalize-arrays-using-swaps/

/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var minCost = function(nums1, nums2) {
    const freq = new Map();
    for (const v of nums1) freq.set(v, (freq.get(v) || 0) + 1);
    for (const v of nums2) freq.set(v, (freq.get(v) || 0) + 1);
    for (const cnt of freq.values()) {
        if (cnt % 2 !== 0) return -1;
    }
    const a = [...nums1].sort((x, y) => x - y);
    const b = [...nums2].sort((x, y) => x - y);
    let diff = 0;
    for (let i = 0; i < a.length; i++) {
        if (a[i] !== b[i]) diff++;
    }
    return diff / 2;
};
