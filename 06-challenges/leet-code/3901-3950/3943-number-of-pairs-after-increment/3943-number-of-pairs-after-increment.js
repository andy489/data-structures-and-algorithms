// https://leetcode.com/problems/number-of-pairs-after-increment/
/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @param {number[][]} queries
 * @return {number[]}
 */
var numberOfPairs = function(nums1, nums2, queries) {
    const m = nums2.length;
    const diff = new Array(m + 1).fill(0);
    const results = [];

    for (const q of queries) {
        if (q[0] === 1) {
            const [, x, y, val] = q;
            diff[x] += val;
            if (y + 1 <= m - 1) {
                diff[y + 1] -= val;
            }
        } else {
            const tot = q[1];
            const freq = new Map();
            let cum = 0;
            for (let i = 0; i < m; i++) {
                cum += diff[i];
                const v = nums2[i] + cum;
                freq.set(v, (freq.get(v) || 0) + 1);
            }
            let count = 0;
            for (const v1 of nums1) {
                const target = tot - v1;
                count += freq.get(target) || 0;
            }
            results.push(count);
        }
    }
    return results;
};
