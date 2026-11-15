// https://leetcode.com/problems/divisor-game/

// Solution: Math — O(1) time, O(1) space
var divisorGame = function(n) {
    return n % 2 === 0;
};

// Solution 2: Dynamic Programming — O(n²) time, O(n) space
var divisorGame2 = function(n) {
    const dp = new Array(n + 1).fill(false);
    for (let i = 2; i <= n; i++) {
        for (let x = 1; x < i; x++) {
            if (i % x === 0 && !dp[i - x]) {
                dp[i] = true;
                break;
            }
        }
    }
    return dp[n];
};
