// https://leetcode.com/problems/minimize-the-difference-between-target-and-chosen-elements/

// Solution: DP with boolean set — O(m * n * maxSum) time, O(maxSum) space
class Solution {
    public int minimizeTheDifference(int[][] mat, int target) {
        int m = mat.length;
        int maxSum = 70 * 70;
        boolean[] dp = new boolean[maxSum + 1];
        dp[0] = true;

        for (int[] row : mat) {
            boolean[] next = new boolean[maxSum + 1];
            for (int s = 0; s <= maxSum; s++) {
                if (!dp[s]) {
                    continue;
                }
                for (int v : row) {
                    if (s + v <= maxSum) {
                        next[s + v] = true;
                    }
                }
            }
            dp = next;
        }

        int ans = Integer.MAX_VALUE;
        for (int s = 0; s <= maxSum; s++) {
            if (dp[s]) {
                ans = Math.min(ans, Math.abs(s - target));
            }
        }
        return ans;
    }
}
