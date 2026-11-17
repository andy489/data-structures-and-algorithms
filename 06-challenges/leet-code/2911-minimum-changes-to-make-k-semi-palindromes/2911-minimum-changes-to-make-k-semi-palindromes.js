// https://leetcode.com/problems/minimum-changes-to-make-k-semi-palindromes/

var minimumChanges = function(s, k) {
    const n = s.length;

    const semiCost = (i, j) => {
        const len = j - i + 1;
        let best = Infinity;
        for (let d = 1; d < len; d++) {
            if (len % d !== 0) continue;
            let changes = 0;
            for (let g = 0; g < d; g++) {
                let lo = i + g, hi = j - (d - 1 - g);
                while (lo < hi) {
                    if (s[lo] !== s[hi]) changes++;
                    lo += d;
                    hi -= d;
                }
            }
            best = Math.min(best, changes);
        }
        return best;
    };

    const dp = Array.from({ length: k + 1 }, () => new Array(n + 1).fill(Infinity));
    dp[0][0] = 0;

    for (let p = 1; p <= k; p++) {
        for (let i = p; i <= n - (k - p); i++) {
            for (let j = p - 1; j < i; j++) {
                if (dp[p - 1][j] < Infinity) {
                    dp[p][i] = Math.min(dp[p][i], dp[p - 1][j] + semiCost(j, i - 1));
                }
            }
        }
    }

    return dp[k][n];
};
