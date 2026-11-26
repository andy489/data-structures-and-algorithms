// https://leetcode.com/problems/maximum-sum-obtained-of-any-permutation/

var maxSumRangeQuery = function(nums, requests) {
    const MOD = 1e9 + 7;
    const n = nums.length;
    const freq = new Array(n + 1).fill(0);
    for (const [l, r] of requests) {
        freq[l]++;
        freq[r + 1]--;
    }
    for (let i = 1; i < n; i++) freq[i] += freq[i - 1];
    nums.sort((a, b) => a - b);
    const freqSlice = freq.slice(0, n).sort((a, b) => a - b);
    let result = 0n;
    for (let i = 0; i < n; i++) {
        result += BigInt(nums[i]) * BigInt(freqSlice[i]);
    }
    return Number(result % BigInt(MOD));
};
