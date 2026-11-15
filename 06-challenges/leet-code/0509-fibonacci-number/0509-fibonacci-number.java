// https://leetcode.com/problems/fibonacci-number/

// Solution: Naive Recursion — O(2^n) time, O(n) space
class Solution {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }
}

// Solution 2: Recursive with Memoisation — O(n) time, O(n) space
class Solution2 {
    private int[] memo = new int[31];

    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        return memo[n] = fib(n - 1) + fib(n - 2);
    }
}

// Solution 3: Iterative DP with Rolling Array — O(n) time, O(1) space
class Solution3 {
    private static final int SIZE = 3;

    public int fib(int n) {
        int[] dp = new int[SIZE];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i % SIZE] = dp[(i - 1) % SIZE] + dp[(i - 2) % SIZE];
        }
        return dp[n % SIZE];
    }
}

// Solution 4: Matrix Exponentiation — O(log n) time, O(log n) space
class Solution4 {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        long[][] result = matpow(new long[][]{{1, 1}, {1, 0}}, n);
        return (int) result[0][1];
    }

    private long[][] matpow(long[][] m, int p) {
        if (p == 1) {
            return m;
        }
        if (p % 2 == 0) {
            long[][] half = matpow(m, p / 2);
            return matmul(half, half);
        }
        return matmul(m, matpow(m, p - 1));
    }

    private long[][] matmul(long[][] a, long[][] b) {
        return new long[][]{
            {a[0][0] * b[0][0] + a[0][1] * b[1][0], a[0][0] * b[0][1] + a[0][1] * b[1][1]},
            {a[1][0] * b[0][0] + a[1][1] * b[1][0], a[1][0] * b[0][1] + a[1][1] * b[1][1]}
        };
    }
}
