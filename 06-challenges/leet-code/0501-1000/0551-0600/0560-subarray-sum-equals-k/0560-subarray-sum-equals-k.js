// https://leetcode.com/problems/subarray-sum-equals-k/
// Solution: Prefix sum HashMap — O(n) time, O(n) space
var subarraySum = function(nums, k) {
    const prefixFreq = new Map();
    prefixFreq.set(0, 1);
    let total = 0;
    let count = 0;
    for (const num of nums) {
        total += num;
        count += (prefixFreq.get(total - k) || 0);
        prefixFreq.set(total, (prefixFreq.get(total) || 0) + 1);
    }
    return count;
};
