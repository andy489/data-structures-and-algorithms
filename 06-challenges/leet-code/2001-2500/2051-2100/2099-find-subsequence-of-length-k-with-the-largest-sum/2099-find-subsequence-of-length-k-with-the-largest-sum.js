// https://leetcode.com/problems/find-subsequence-of-length-k-with-the-largest-sum/

// Solution: Sort by Value, Keep Original Order — O(n log n) time, O(n) space
var maxSubsequence = function(nums, k) {
    const indices = [...nums.keys()].sort((a, b) => nums[b] - nums[a]).slice(0, k).sort((a, b) => a - b);
    return indices.map(i => nums[i]);
};
