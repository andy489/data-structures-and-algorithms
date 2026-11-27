// https://leetcode.com/problems/climbing-stairs/

// Solution: Fibonacci iteration — O(n) time, O(1) space
// ways(n) = ways(n-1) + ways(n-2); track only last two values.
class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int prev2 = 1, prev1 = 2;
        for (int i = 3; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}

// Solution2: Bottom-up DP — O(n) time, O(n) space
class Solution2 {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}

// Solution3: Matrix exponentiation — O(log n) time, O(1) space
// [F(n+1)]   [1 1]^n   [1]
// [F(n)  ] = [1 0]   * [0]
class Solution3 {
    public int climbStairs(int n) {
        int[][] base = {{1, 1}, {1, 0}};
        int[][] result = matPow(base, n);
        return result[0][0];
    }

    private int[][] matPow(int[][] m, int p) {
        int[][] result = {{1, 0}, {0, 1}}; // identity
        while (p > 0) {
            if ((p & 1) == 1) {
                result = matMul(result, m);
            }
            m = matMul(m, m);
            p >>= 1;
        }
        return result;
    }

    private int[][] matMul(int[][] a, int[][] b) {
        return new int[][]{
            {a[0][0] * b[0][0] + a[0][1] * b[1][0], a[0][0] * b[0][1] + a[0][1] * b[1][1]},
            {a[1][0] * b[0][0] + a[1][1] * b[1][0], a[1][0] * b[0][1] + a[1][1] * b[1][1]}
        };
    }
}
