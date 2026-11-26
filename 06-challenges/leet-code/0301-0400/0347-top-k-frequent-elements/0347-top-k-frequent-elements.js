// https://leetcode.com/problems/top-k-frequent-elements/

// Solution: Bucket Sort — O(n) time, O(n) space
var topKFrequent = function(nums, k) {
    const freq = new Map();
    for (const n of nums) freq.set(n, (freq.get(n) || 0) + 1);
    const buckets = new Array(nums.length + 1).fill(null).map(() => []);
    for (const [num, f] of freq) buckets[f].push(num);
    const result = [];
    for (let i = buckets.length - 1; i >= 0 && result.length < k; i--) {
        for (const num of buckets[i]) {
            result.push(num);
            if (result.length === k) break;
        }
    }
    return result;
};
