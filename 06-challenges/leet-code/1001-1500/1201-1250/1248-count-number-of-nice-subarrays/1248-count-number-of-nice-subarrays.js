// https://leetcode.com/problems/count-number-of-nice-subarrays/

var numberOfSubarrays = function(nums, k) {
    const count = new Map([[0, 1]]);
    let prefix = 0, res = 0;
    for (const x of nums) {
        prefix += x & 1;
        res += count.get(prefix - k) || 0;
        count.set(prefix, (count.get(prefix) || 0) + 1);
    }
    return res;
};
