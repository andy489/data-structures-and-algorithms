// https://leetcode.com/problems/sum-of-subsequence-widths/

var sumSubseqWidths = function(nums) {
    const MOD = 1000000007n;
    nums.sort((a, b) => a - b);
    const n = nums.length;
    const pow2 = Array(n).fill(1n);
    for (let i = 1; i < n; i++) pow2[i] = pow2[i-1] * 2n % MOD;
    let ans = 0n;
    for (let i = 0; i < n; i++) {
        ans = (ans + BigInt(nums[i]) * (pow2[i] - pow2[n-1-i]) % MOD + MOD) % MOD;
    }
    return Number(ans);
};
