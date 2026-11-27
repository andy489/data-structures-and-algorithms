// https://leetcode.com/problems/k-concatenation-maximum-sum/

// Solution: Kadane + Total Sum — O(n) time, O(1) space
var kConcatenationMaxSum = function(arr, k) {
    const MOD = 1_000_000_007n;

    function kadane(repeat) {
        let maxSum = 0n, cur = 0n;
        for (let r = 0; r < repeat; r++) {
            for (const x of arr) {
                cur = cur + BigInt(x) < 0n ? 0n : cur + BigInt(x);
                if (cur > maxSum) {
                    maxSum = cur;
                }
            }
        }
        return maxSum;
    }

    const total = arr.reduce((a, b) => a + b, 0);
    if (k === 1) {
        return Number(kadane(1) % MOD);
    }
    const maxSub2 = kadane(2);
    if (total > 0) {
        return Number((maxSub2 + BigInt(k - 2) * BigInt(total)) % MOD);
    }
    return Number(maxSub2 % MOD);
};
