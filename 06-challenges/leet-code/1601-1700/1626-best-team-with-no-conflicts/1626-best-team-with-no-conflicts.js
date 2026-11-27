// https://leetcode.com/problems/best-team-with-no-conflicts/

var bestTeamScore = function(scores, ages) {
    const n = scores.length;
    const players = ages.map((a, i) => [a, scores[i]]);
    players.sort((x, y) => x[0] !== y[0] ? x[0] - y[0] : x[1] - y[1]);
    const dp = players.map(([, s]) => s);
    let ans = 0;
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < i; j++) {
            if (players[j][1] <= players[i][1]) {
                dp[i] = Math.max(dp[i], dp[j] + players[i][1]);
            }
        }
        ans = Math.max(ans, dp[i]);
    }
    return ans;
};
