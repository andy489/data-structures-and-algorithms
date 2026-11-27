// https://leetcode.com/problems/find-the-maximum-number-of-fruits-collected/

// Solution: Independent DP for Each Side Child — O(n^2) time, O(n^2) space
var maxCollectedFruits = function(fruits) {
    const n = fruits.length;
    const NEG_INF = -Infinity;

    // Child 1: forced diagonal
    let diag = 0;
    for (let i = 0; i < n; i++) {
        diag += fruits[i][i];
    }

    // Child 2: (0, n-1) -> (n-1, n-1)
    const dp2 = Array.from({length: n}, () => new Array(n).fill(NEG_INF));
    dp2[0][n - 1] = fruits[0][n - 1];
    for (let i = 1; i < n; i++) {
        for (let j = 0; j < n; j++) {
            if (i === j) {
                continue;
            }
            let best = NEG_INF;
            for (const dj of [-1, 0, 1]) {
                const pj = j - dj;
                if (pj >= 0 && pj < n && dp2[i - 1][pj] !== NEG_INF) {
                    best = Math.max(best, dp2[i - 1][pj]);
                }
            }
            if (best !== NEG_INF) {
                dp2[i][j] = best + fruits[i][j];
            }
        }
    }
    const child2 = dp2[n - 1][n - 1];

    // Child 3: (n-1, 0) -> (n-1, n-1)
    const dp3 = Array.from({length: n}, () => new Array(n).fill(NEG_INF));
    dp3[n - 1][0] = fruits[n - 1][0];
    for (let j = 1; j < n; j++) {
        for (let i = 0; i < n; i++) {
            if (i === j) {
                continue;
            }
            let best = NEG_INF;
            for (const di of [-1, 0, 1]) {
                const pi = i - di;
                if (pi >= 0 && pi < n && dp3[pi][j - 1] !== NEG_INF) {
                    best = Math.max(best, dp3[pi][j - 1]);
                }
            }
            if (best !== NEG_INF) {
                dp3[i][j] = best + fruits[i][j];
            }
        }
    }
    const child3 = dp3[n - 1][n - 1];

    return diag + child2 + child3;
};
