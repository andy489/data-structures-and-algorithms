// https://leetcode.com/problems/range-sum-of-sorted-subarray-sums/

var rangeSum = function(nums, n, left, right) {
    const MOD = 1_000_000_007n;
    const sums = [];
    for (let i = 0; i < n; i++) {
        let cur = 0;
        for (let j = i; j < n; j++) {
            cur += nums[j];
            sums.push(cur);
        }
    }
    sums.sort((a, b) => a - b);
    let ans = 0n;
    for (let i = left - 1; i < right; i++) {
        ans = (ans + BigInt(sums[i])) % MOD;
    }
    return Number(ans);
};
