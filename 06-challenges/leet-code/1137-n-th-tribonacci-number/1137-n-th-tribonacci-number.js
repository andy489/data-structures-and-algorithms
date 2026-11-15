// https://leetcode.com/problems/n-th-tribonacci-number/

// Solution: Naive Recursion — O(3^n) time, O(n) space
var tribonacci = function(n) {
    if (n === 0) return 0;
    if (n <= 2) return 1;
    return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
};

// Solution 2: Recursive with Memoisation — O(n) time, O(n) space
var tribonacci2 = function(n, memo = {}) {
    if (n === 0) return 0;
    if (n <= 2) return 1;
    if (n in memo) return memo[n];
    return memo[n] = tribonacci2(n - 1, memo) + tribonacci2(n - 2, memo) + tribonacci2(n - 3, memo);
};

// Solution 3: Iterative DP with Rolling Array — O(n) time, O(1) space
var tribonacci3 = function(n) {
    if (n === 0) return 0;
    const SIZE = 4;
    const dp = new Array(SIZE).fill(0);
    dp[1] = dp[2] = 1;
    for (let i = 3; i <= n; i++) {
        dp[i % SIZE] = dp[(i - 1) % SIZE] + dp[(i - 2) % SIZE] + dp[(i - 3) % SIZE];
    }
    return dp[n % SIZE];
};
