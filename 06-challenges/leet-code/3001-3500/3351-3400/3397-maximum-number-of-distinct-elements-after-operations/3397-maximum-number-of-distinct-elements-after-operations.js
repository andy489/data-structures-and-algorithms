// https://leetcode.com/problems/maximum-number-of-distinct-elements-after-operations/

var maxDistinctElements = function(nums, k) {
    nums.sort((a, b) => a - b);
    let count = 0, prev = -Infinity;
    for (const x of nums) {
        const candidate = Math.max(x - k, prev + 1);
        if (candidate <= x + k) {
            count++;
            prev = candidate;
        }
    }
    return count;
};
