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
