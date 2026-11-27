// https://leetcode.com/problems/minimum-operations-to-achieve-at-least-k-peaks/
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var minOperations = function(nums, k) {
    const n = nums.length;
    if (k === 0) {
        return 0;
    }
    if (k > Math.floor(n / 2)) {
        return -1;
    }

    let best = Infinity;

    for (let s = 0; s < n; s++) {
        let cost = 0;
        let pos = s;
        for (let p = 0; p < k; p++) {
            const prev = (pos - 1 + n) % n;
            const next = (pos + 1) % n;
            const need = Math.max(nums[prev], nums[next]) + 1 - nums[pos];
            if (need > 0) {
                cost += need;
            }
            pos = (pos + 2) % n;
        }
        best = Math.min(best, cost);
    }

    return best;
};
