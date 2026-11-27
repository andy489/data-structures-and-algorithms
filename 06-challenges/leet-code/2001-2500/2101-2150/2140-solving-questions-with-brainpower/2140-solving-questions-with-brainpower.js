// https://leetcode.com/problems/solving-questions-with-brainpower/
var mostPoints = function(questions) {
    const n = questions.length;
    const dp = new Array(n + 1).fill(0);
    for (let i = n - 1; i >= 0; i--) {
        const [points, skip] = questions[i];
        const next = Math.min(n, i + skip + 1);
        dp[i] = Math.max(dp[i + 1], points + dp[next]);
    }
    return dp[0];
};
