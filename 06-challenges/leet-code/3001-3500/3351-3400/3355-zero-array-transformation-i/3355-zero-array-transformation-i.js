// https://leetcode.com/problems/zero-array-transformation-i/

// Solution: Difference Array — O(n + q) time, O(n) space
var isZeroArray = function(nums, queries) {
    const n = nums.length;
    const diff = new Array(n + 1).fill(0);
    for (const [l, r] of queries) {
        diff[l]++;
        diff[r + 1]--;
    }
    let coverage = 0;
    for (let i = 0; i < n; i++) {
        coverage += diff[i];
        if (coverage < nums[i]) {
            return false;
        }
    }
    return true;
};
