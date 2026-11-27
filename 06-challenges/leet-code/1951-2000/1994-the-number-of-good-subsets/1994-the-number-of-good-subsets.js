// https://leetcode.com/problems/the-number-of-good-subsets/
/**
 * @param {number[]} nums
 * @return {number}
 */
var numberOfGoodSubsets = function(nums) {
    const MOD = 1_000_000_007n;
    const PRIMES = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29];

    const count = new Int32Array(31);
    for (const x of nums) {
        count[x]++;
    }

    const primeMask = new Array(31).fill(-1);
    for (let v = 2; v <= 30; v++) {
        let temp = v, mask = 0, valid = true;
        for (let i = 0; i < PRIMES.length; i++) {
            const p = PRIMES[i];
            if (temp % p === 0) {
                mask |= (1 << i);
                temp = Math.floor(temp / p);
                if (temp % p === 0) {
                    valid = false;
                    break;
                }
            }
        }
        if (valid) {
            primeMask[v] = mask;
        }
    }

    const dp = new Array(1 << PRIMES.length).fill(0n);
    dp[0] = 1n;
    for (let v = 2; v <= 30; v++) {
        if (count[v] === 0 || primeMask[v] < 0) {
            continue;
        }
        const mask = primeMask[v];
        for (let prev = dp.length - 1; prev >= 0; prev--) {
            if (dp[prev] === 0n || (prev & mask) !== 0) {
                continue;
            }
            dp[prev | mask] = (dp[prev | mask] + dp[prev] * BigInt(count[v])) % MOD;
        }
    }

    let result = 0n;
    for (let i = 1; i < dp.length; i++) {
        result = (result + dp[i]) % MOD;
    }
    let pow2 = 1n;
    for (let i = 0; i < count[1]; i++) {
        pow2 = pow2 * 2n % MOD;
    }
    return Number(result * pow2 % MOD);
};
