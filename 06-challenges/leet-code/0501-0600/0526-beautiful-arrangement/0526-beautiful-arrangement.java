// https://leetcode.com/problems/beautiful-arrangement/

// Solution: Backtracking — O(k) time, O(n) space
class Solution {
    private int count = 0;

    public int countArrangement(int n) {
        boolean[] visited = new boolean[n + 1];
        backtrack(n, 1, visited);
        return count;
    }

    private void backtrack(int n, int pos, boolean[] visited) {
        if (pos > n) {
            count++;
            return;
        }
        for (int num = 1; num <= n; num++) {
            if (!visited[num] && (num % pos == 0 || pos % num == 0)) {
                visited[num] = true;
                backtrack(n, pos + 1, visited);
                visited[num] = false;
            }
        }
    }
}

// Solution 2: Bitmask DP — O(n·2^n) time, O(2^n) space
class Solution2 {
    public int countArrangement(int n) {
        int[] dp = new int[1 << n];
        dp[0] = 1;
        for (int mask = 0; mask < (1 << n); mask++) {
            int pos = Integer.bitCount(mask) + 1;
            for (int num = 1; num <= n; num++) {
                if ((mask & (1 << (num - 1))) == 0 && (num % pos == 0 || pos % num == 0)) {
                    dp[mask | (1 << (num - 1))] += dp[mask];
                }
            }
        }
        return dp[(1 << n) - 1];
    }
}
