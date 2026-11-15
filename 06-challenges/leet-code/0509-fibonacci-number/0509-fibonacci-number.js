// https://leetcode.com/problems/fibonacci-number/

// Solution: Naive Recursion — O(2^n) time, O(n) space
var fib = function(n) {
    if (n <= 1) return n;
    return fib(n - 1) + fib(n - 2);
};

// Solution 2: Recursive with Memoisation — O(n) time, O(n) space
var fib2 = function(n, memo = {}) {
    if (n <= 1) return n;
    if (n in memo) return memo[n];
    return memo[n] = fib2(n - 1, memo) + fib2(n - 2, memo);
};

// Solution 3: Iterative DP with Rolling Array — O(n) time, O(1) space
var fib3 = function(n) {
    const SIZE = 3;
    const dp = new Array(SIZE).fill(0);
    dp[1] = 1;
    for (let i = 2; i <= n; i++) {
        dp[i % SIZE] = dp[(i - 1) % SIZE] + dp[(i - 2) % SIZE];
    }
    return dp[n % SIZE];
};

// Solution 4: Matrix Exponentiation — O(log n) time, O(log n) space
var fib4 = function(n) {
    if (n <= 1) return n;

    function matmul(a, b) {
        return [
            [a[0][0] * b[0][0] + a[0][1] * b[1][0], a[0][0] * b[0][1] + a[0][1] * b[1][1]],
            [a[1][0] * b[0][0] + a[1][1] * b[1][0], a[1][0] * b[0][1] + a[1][1] * b[1][1]],
        ];
    }

    function matpow(m, p) {
        if (p === 1) return m;
        if (p % 2 === 0) {
            const half = matpow(m, p / 2);
            return matmul(half, half);
        }
        return matmul(m, matpow(m, p - 1));
    }

    return matpow([[1, 1], [1, 0]], n)[0][1];
};
