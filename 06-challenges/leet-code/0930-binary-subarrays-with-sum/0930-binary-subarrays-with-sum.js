// https://leetcode.com/problems/binary-subarrays-with-sum/

var numSubarraysWithSum = function(nums, goal) {
    const count = new Map([[0, 1]]);
    let prefix = 0, result = 0;
    for (const x of nums) {
        prefix += x;
        result += (count.get(prefix - goal) || 0);
        count.set(prefix, (count.get(prefix) || 0) + 1);
    }
    return result;
};
