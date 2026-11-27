// https://leetcode.com/problems/number-of-ways-to-separate-numbers/

// Solution: DP with LCP — O(n^2) time, O(n^2) space
var numberOfCombinations = function(num) {
    const MOD = 1_000_000_007n;
    const n = num.length;
    if (num[0] === '0') return 0;

    // lcp[i][j] = length of common prefix of num[i:] and num[j:]
    const lcp = Array.from({length: n + 1}, () => new Int32Array(n + 1));
    for (let i = n - 1; i >= 0; i--) {
        for (let j = n - 1; j >= 0; j--) {
            lcp[i][j] = num[i] === num[j] ? lcp[i + 1][j + 1] + 1 : 0;
        }
    }

    const dp = Array.from({length: n}, () => new BigInt64Array(n));
    const prefix = Array.from({length: n}, () => new BigInt64Array(n));

    for (let i = 0; i < n; i++) {
        for (let j = 0; j <= i; j++) {
            if (num[j] === '0') {
                dp[i][j] = 0n;
            } else if (j === 0) {
                dp[i][j] = 1n;
            } else {
                const len = i - j + 1;
                const lo = Math.max(0, j - len);
                let rangeSum = prefix[j - 1][j - 1] - (lo > 0 ? prefix[j - 1][lo - 1] : 0n);
                const k = j - len;
                if (lo === k && k >= 0 && num[k] !== '0') {
                    const common = lcp[k][j];
                    if (common < len && num[k + common] > num[j + common]) {
                        rangeSum -= dp[j - 1][k];
                    }
                }
                dp[i][j] = ((rangeSum % MOD) + MOD) % MOD;
            }
            prefix[i][j] = ((j > 0 ? prefix[i][j - 1] : 0n) + dp[i][j]) % MOD;
        }
    }
    return Number(prefix[n - 1][n - 1]);
};
