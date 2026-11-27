// https://leetcode.com/problems/minimum-absolute-difference-between-two-values/

/**
 * @param {number[]} nums
 * @return {number}
 */
var minAbsDiff = function(nums) {
    const ones = [], twos = [];
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] === 1) { ones.push(i); }
        else if (nums[i] === 2) { twos.push(i); }
    }
    if (!ones.length || !twos.length) { return -1; }
    let ans = Infinity, i = 0, j = 0;
    while (i < ones.length && j < twos.length) {
        ans = Math.min(ans, Math.abs(ones[i] - twos[j]));
        if (ones[i] < twos[j]) { i++; } else { j++; }
    }
    return ans;
};
