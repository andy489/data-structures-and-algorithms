// https://leetcode.com/problems/split-the-array-to-make-coprime-products/

/**
 * @param {number[]} nums
 * @return {number}
 */
var findValidSplit = function(nums) {
    const n = nums.length;
    const lastSeen = new Map();

    for (let i = 0; i < n; i++) {
        let x = nums[i];
        for (let p = 2; p * p <= x; p++) {
            if (x % p === 0) {
                lastSeen.set(p, i);
                while (x % p === 0) x = Math.floor(x / p);
            }
        }
        if (x > 1) lastSeen.set(x, i);
    }

    let maxRight = 0;
    for (let i = 0; i < n - 1; i++) {
        let x = nums[i];
        for (let p = 2; p * p <= x; p++) {
            if (x % p === 0) {
                maxRight = Math.max(maxRight, lastSeen.get(p));
                while (x % p === 0) x = Math.floor(x / p);
            }
        }
        if (x > 1) maxRight = Math.max(maxRight, lastSeen.get(x));
        if (maxRight === i) return i;
    }
    return -1;
};
