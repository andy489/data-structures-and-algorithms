// https://leetcode.com/problems/largest-divisible-subset/

// Solution: Sort + DP — O(n²) time, O(n) space
var largestDivisibleSubset = function(nums) {
    nums.sort((a, b) => a - b);
    const n = nums.length;
    const dp = new Array(n).fill(1);
    const parent = new Array(n).fill(-1);

    let maxLen = 1, maxIdx = 0;
    for (let i = 1; i < n; i++) {
        for (let j = 0; j < i; j++) {
            if (nums[i] % nums[j] === 0 && dp[j] + 1 > dp[i]) {
                dp[i] = dp[j] + 1;
                parent[i] = j;
            }
        }
        if (dp[i] > maxLen) { maxLen = dp[i]; maxIdx = i; }
    }

    const result = [];
    for (let i = maxIdx; i >= 0; i = parent[i]) {
        result.push(nums[i]);
        if (parent[i] === -1) break;
    }
    return result;
};
