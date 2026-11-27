// https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/

// Solution: Monotonic Stack — O(n) time, O(n) space
class Solution {
    public int mctFromLeafValues(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(Integer.MAX_VALUE);
        int ans = 0;
        for (int v : arr) {
            while (stack.peek() <= v) {
                int mid = stack.pop();
                ans += mid * Math.min(stack.peek(), v);
            }
            stack.push(v);
        }
        while (stack.size() > 2) {
            int top = stack.pop();
            ans += top * stack.peek();
        }
        return ans;
    }
}

// Solution 2: Interval DP — O(n^3) time, O(n^2) space
class Solution2 {
    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        int[][] maxVal = new int[n][n];
        for (int i = 0; i < n; i++) {
            maxVal[i][i] = arr[i];
            for (int j = i + 1; j < n; j++) {
                maxVal[i][j] = Math.max(maxVal[i][j - 1], arr[j]);
            }
        }
        int[][] dp = new int[n][n];
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j],
                        dp[i][k] + dp[k + 1][j] + maxVal[i][k] * maxVal[k + 1][j]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
