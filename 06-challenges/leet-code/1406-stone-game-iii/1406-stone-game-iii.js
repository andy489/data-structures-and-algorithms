// https://leetcode.com/problems/stone-game-iii/

var stoneGameIII = function(stoneValue) {
    const n = stoneValue.length;
    const dp = new Array(n + 1).fill(0);
    for (let i = n - 1; i >= 0; i--) {
        dp[i] = -Infinity;
        let s = 0;
        for (let k = 1; k <= 3 && i + k <= n; k++) {
            s += stoneValue[i + k - 1];
            dp[i] = Math.max(dp[i], s - dp[i + k]);
        }
    }
    const total = stoneValue.reduce((a, b) => a + b, 0);
    const alice = dp[0], bob = total - dp[0];
    return alice > bob ? "Alice" : alice < bob ? "Bob" : "Tie";
};
