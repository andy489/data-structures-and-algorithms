// https://leetcode.com/problems/maximize-consecutive-elements-in-an-array-after-modification/

// Solution: Sort + DP — O(n log n) time, O(n) space
var maximumSelectedElements = function(nums) {
    nums.sort((a, b) => a - b);
    const dp = new Map();
    let ans = 0;
    for (const x of nums) {
        dp.set(x + 1, (dp.get(x) ?? 0) + 1);
        dp.set(x, (dp.get(x - 1) ?? 0) + 1);
        ans = Math.max(ans, dp.get(x + 1), dp.get(x));
    }
    return ans;
};
