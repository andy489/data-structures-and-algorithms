// https://leetcode.com/problems/stone-game-iv/

var winnerSquareGame = function(n) {
    const dp = new Array(n + 1).fill(false);
    for (let i = 1; i <= n; i++) {
        for (let k = 1; k * k <= i; k++) {
            if (!dp[i - k * k]) {
                dp[i] = true;
                break;
            }
        }
    }
    return dp[n];
};
