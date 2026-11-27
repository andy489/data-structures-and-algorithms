// https://leetcode.com/problems/count-k-reducible-numbers-less-than-n/

// Solution: Digit DP + Popcount Reduction Check — O(n^2) time, O(n^2) space
var countKReducibleNumbers = function(s, k) {
    const MOD = 1_000_000_007n;
    const n = s.length;

    // Pascal's triangle
    const C = Array.from({length: n + 1}, () => new Array(n + 1).fill(0n));
    C[0][0] = 1n;
    for (let i = 1; i <= n; i++) {
        C[i][0] = 1n;
        for (let j = 1; j <= i; j++) {
            C[i][j] = (C[i - 1][j - 1] + C[i - 1][j]) % MOD;
        }
    }

    // steps[c] = ops to reduce c to 1
    const steps = new Array(n + 1).fill(0);
    for (let c = 2; c <= n; c++) {
        steps[c] = 1 + steps[c.toString(2).split('').filter(b => b === '1').length];
    }

    let ans = 0n;
    for (let c = 1; c <= n; c++) {
        if (steps[c] >= k) {
            continue;
        }
        let onesPlaced = 0;
        for (let i = 0; i < n; i++) {
            if (s[i] === '1') {
                const remaining = n - 1 - i;
                const need = c - onesPlaced;
                if (need >= 0 && need <= remaining) {
                    ans = (ans + C[remaining][need]) % MOD;
                }
                onesPlaced++;
            }
            if (onesPlaced > c) {
                break;
            }
        }
    }
    return Number(ans);
};
