// https://leetcode.com/problems/maximum-number-of-non-overlapping-subarrays-with-sum-equals-target/

var maxNonOverlapping = function(nums, target) {
    let seen = new Set([0]);
    let prefix = 0, count = 0;
    for (const num of nums) {
        prefix += num;
        if (seen.has(prefix - target)) {
            count++;
            seen = new Set([0]);
            prefix = 0;
        } else {
            seen.add(prefix);
        }
    }
    return count;
};
