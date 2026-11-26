// https://leetcode.com/problems/minimum-subsequence-in-non-increasing-order/

var minSubsequence = function(nums) {
    nums.sort((a, b) => b - a);
    const total = nums.reduce((s, x) => s + x, 0);
    const res = [];
    let sub = 0;
    for (const n of nums) {
        sub += n;
        res.push(n);
        if (sub > total - sub) break;
    }
    return res;
};
