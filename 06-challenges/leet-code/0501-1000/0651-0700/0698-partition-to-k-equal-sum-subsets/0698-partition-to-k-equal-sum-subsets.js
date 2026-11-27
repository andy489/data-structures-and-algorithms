// https://leetcode.com/problems/partition-to-k-equal-sum-subsets/

var canPartitionKSubsets = function(nums, k) {
    const total = nums.reduce((a, b) => a + b, 0);
    if (total % k !== 0) return false;
    const target = total / k;
    nums.sort((a, b) => b - a);
    if (nums[0] > target) return false;
    const buckets = new Array(k).fill(0);

    function backtrack(idx) {
        if (idx === nums.length) return true;
        const seen = new Set();
        for (let i = 0; i < k; i++) {
            if (seen.has(buckets[i])) continue;
            if (buckets[i] + nums[idx] <= target) {
                seen.add(buckets[i]);
                buckets[i] += nums[idx];
                if (backtrack(idx + 1)) return true;
                buckets[i] -= nums[idx];
            }
        }
        return false;
    }

    return backtrack(0);
};
