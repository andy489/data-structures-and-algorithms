// https://leetcode.com/problems/stone-game-vii/

var stoneGameVII = function(stones) {
    const n = stones.length;
    const prefix = new Array(n + 1).fill(0);
    for (let i = 0; i < n; i++) {
        prefix[i + 1] = prefix[i] + stones[i];
    }
    const dp = Array.from({ length: n }, () => new Array(n).fill(0));
    for (let len = 2; len <= n; len++) {
        for (let l = 0; l + len - 1 < n; l++) {
            const r = l + len - 1;
            const sumWithoutLeft  = prefix[r + 1] - prefix[l + 1];
            const sumWithoutRight = prefix[r]     - prefix[l];
            dp[l][r] = Math.max(
                sumWithoutLeft  - dp[l + 1][r],
                sumWithoutRight - dp[l][r - 1]
            );
        }
    }
    return dp[0][n - 1];
};
