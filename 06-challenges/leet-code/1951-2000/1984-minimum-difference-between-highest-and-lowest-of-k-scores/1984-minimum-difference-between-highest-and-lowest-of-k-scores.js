// https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/

// Solution: Sorting + Sliding Window — O(n log n) time, O(1) space
var minimumDifference = function(nums, k) {
    nums.sort((a, b) => a - b);
    let ans = Infinity;
    for (let i = 0; i + k - 1 < nums.length; i++) {
        ans = Math.min(ans, nums[i + k - 1] - nums[i]);
    }
    return ans;
};
