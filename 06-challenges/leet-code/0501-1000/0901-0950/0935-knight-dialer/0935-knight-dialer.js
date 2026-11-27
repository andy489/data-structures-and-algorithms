// https://leetcode.com/problems/knight-dialer/

var knightDialer = function(n) {
    const MOD = 1e9 + 7;
    const moves = [[4,6],[6,8],[7,9],[4,8],[0,3,9],[],[0,1,7],[2,6],[1,3],[2,4]];
    let dp = new Array(10).fill(1);
    for (let i = 1; i < n; i++) {
        const ndp = new Array(10).fill(0);
        for (let d = 0; d < 10; d++) {
            for (const nxt of moves[d]) ndp[nxt] = (ndp[nxt] + dp[d]) % MOD;
        }
        dp = ndp;
    }
    return dp.reduce((a, b) => (a + b) % MOD, 0);
};
