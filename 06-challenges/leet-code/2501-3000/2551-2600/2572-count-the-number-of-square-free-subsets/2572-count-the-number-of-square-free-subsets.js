// https://leetcode.com/problems/count-the-number-of-square-free-subsets/

/**
 * @param {number[]} nums
 * @return {number}
 */
var squareFreeSubsets = function(nums) {
    const MOD = 1_000_000_007n;
    const primes = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29];

    function primeMask(x) {
        let mask = 0;
        for (let i = 0; i < primes.length; i++) {
            const p = primes[i];
            if (x % p === 0) {
                x = Math.floor(x / p);
                if (x % p === 0) return -1;
                mask |= (1 << i);
            }
        }
        return mask;
    }

    const dp = new Array(1 << 10).fill(0n);
    dp[0] = 1n;
    let ones = 0;

    for (const x of nums) {
        if (x === 1) {
            ones++;
            continue;
        }
        const mask = primeMask(x);
        if (mask === -1) continue;
        for (let m = (1 << 10) - 1; m >= 0; m--) {
            if ((m & mask) === 0 && dp[m] > 0n) {
                dp[m | mask] = (dp[m | mask] + dp[m]) % MOD;
            }
        }
    }

    let result = 0n;
    for (let m = 1; m < (1 << 10); m++) {
        result = (result + dp[m]) % MOD;
    }

    let pow2 = 1n;
    for (let i = 0; i < ones; i++) {
        pow2 = pow2 * 2n % MOD;
    }
    result = result * pow2 % MOD;
    result = (result + pow2 - 1n + MOD) % MOD;
    return Number(result);
};
