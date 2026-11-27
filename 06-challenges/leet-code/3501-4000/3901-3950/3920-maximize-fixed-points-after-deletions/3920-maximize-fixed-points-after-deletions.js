// https://leetcode.com/problems/maximize-fixed-points-after-deletions/
/**
 * @param {number[]} nums
 * @return {number}
 */
var maximizeFixedPoints = function(nums) {
    const best = new Map();
    let ans = 0;
    for (const v of nums) {
        const prev = best.get(v - 1) || 0;
        const newBest = prev + 1;
        if (newBest > (best.get(v) || 0)) {
            best.set(v, newBest);
        }
        ans = Math.max(ans, best.get(v));
    }
    return ans;
};
