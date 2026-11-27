// https://leetcode.com/problems/super-ugly-number/

// Solution: DP with k Pointers — O(n*k) time, O(n+k) space
var nthSuperUglyNumber = function(n, primes) {
    const dp = new Array(n).fill(0);
    dp[0] = 1;
    const ptrs = new Array(primes.length).fill(0);
    for (let i = 1; i < n; i++) {
        const candidates = primes.map((p, j) => dp[ptrs[j]] * p);
        const minVal = Math.min(...candidates);
        dp[i] = minVal;
        for (let j = 0; j < primes.length; j++) {
            if (candidates[j] === minVal) ptrs[j]++;
        }
    }
    return dp[n - 1];
};
