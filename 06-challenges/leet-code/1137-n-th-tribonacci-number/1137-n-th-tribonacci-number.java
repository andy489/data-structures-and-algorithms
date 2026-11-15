// https://leetcode.com/problems/n-th-tribonacci-number/

// Solution: Naive Recursion — O(3^n) time, O(n) space
class Solution {
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }
        return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
    }
}

// Solution 2: Recursive with Memoisation — O(n) time, O(n) space
class Solution2 {
    private int[] memo = new int[38];

    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        return memo[n] = tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
    }
}

// Solution 3: Iterative DP with Rolling Array — O(n) time, O(1) space
class Solution3 {
    private static final int SIZE = 4;

    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[SIZE];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i % SIZE] = dp[(i - 1) % SIZE] + dp[(i - 2) % SIZE] + dp[(i - 3) % SIZE];
        }
        return dp[n % SIZE];
    }
}

// Solution 4: Matrix Exponentiation — O(log n) time, O(1) space
class Solution4 {
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }
        long[][] result = matpow(new long[][]{{1, 1, 1}, {1, 0, 0}, {0, 1, 0}}, n - 2);
        return (int) (result[0][0] + result[0][1]);
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
        int s = a.length;
        long[][] c = new long[s][s];
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < s; j++) {
                for (int k = 0; k < s; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }
}
