// https://leetcode.com/problems/super-egg-drop/

var superEggDrop = function(k, n) {
    const dp = new Array(k + 1).fill(0);
    let t = 0;
    while (dp[k] < n) {
        t++;
        for (let j = k; j >= 1; j--) {
            dp[j] = dp[j - 1] + dp[j] + 1;
        }
    }
    return t;
};
