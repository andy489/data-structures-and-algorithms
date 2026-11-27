// https://leetcode.com/problems/maximum-height-by-stacking-cuboids/

var maxHeight = function(cuboids) {
    for (const c of cuboids) {
        c.sort((a, b) => a - b);
    }
    cuboids.sort((a, b) => a[0] !== b[0] ? a[0] - b[0] : a[1] !== b[1] ? a[1] - b[1] : a[2] - b[2]);
    const n = cuboids.length;
    const dp = cuboids.map(c => c[2]);
    let ans = 0;
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < i; j++) {
            if (cuboids[j][0] <= cuboids[i][0] &&
                cuboids[j][1] <= cuboids[i][1] &&
                cuboids[j][2] <= cuboids[i][2]) {
                dp[i] = Math.max(dp[i], dp[j] + cuboids[i][2]);
            }
        }
        ans = Math.max(ans, dp[i]);
    }
    return ans;
};
