// https://leetcode.com/problems/minimum-increment-operations-to-make-array-beautiful/

var minIncrementOperations = function(nums, k) {
    let dp0 = 0, dp1 = 0, dp2 = 0;
    for (const num of nums) {
        const cost = Math.max(0, k - num);
        const cur = cost + Math.min(dp0, dp1, dp2);
        [dp0, dp1, dp2] = [dp1, dp2, cur];
    }
    return Math.min(dp0, dp1, dp2);
};
