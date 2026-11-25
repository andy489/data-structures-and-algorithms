// https://leetcode.com/problems/number-of-music-playlists/

var numMusicPlaylists = function(n, goal, k) {
    const MOD = 1e9 + 7;
    const dp = Array.from({length: goal+1}, () => new Array(n+1).fill(0));
    dp[0][0] = 1;
    for (let i = 1; i <= goal; i++) {
        for (let j = 1; j <= n; j++) {
            dp[i][j] = dp[i-1][j-1] * (n - (j-1)) % MOD;
            if (j > k) dp[i][j] = (dp[i][j] + dp[i-1][j] * (j - k)) % MOD;
        }
    }
    return dp[goal][n];
};
