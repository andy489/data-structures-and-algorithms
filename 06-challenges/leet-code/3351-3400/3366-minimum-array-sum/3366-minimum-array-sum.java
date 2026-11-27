// https://leetcode.com/problems/minimum-array-sum/

// Solution: 2D Dynamic Programming — O(n·op1·op2) time, O(op1·op2) space
class Solution {
    public int minArraySum(int[] nums, int k, int op1, int op2) {
        int INF = Integer.MAX_VALUE / 2;
        int[][] dp = new int[op1 + 1][op2 + 1];
        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }
        dp[0][0] = 0;

        for (int x : nums) {
            int[][] next = new int[op1 + 1][op2 + 1];
            for (int[] row : next) {
                Arrays.fill(row, INF);
            }
            for (int i = 0; i <= op1; i++) {
                for (int j = 0; j <= op2; j++) {
                    if (dp[i][j] == INF) {
                        continue;
                    }
                    int cur = dp[i][j];
                    // No op
                    next[i][j] = Math.min(next[i][j], cur + x);
                    // Op1 only
                    if (i < op1) {
                        next[i + 1][j] = Math.min(next[i + 1][j], cur + (x + 1) / 2);
                    }
                    // Op2 only
                    if (j < op2 && x >= k) {
                        next[i][j + 1] = Math.min(next[i][j + 1], cur + x - k);
                    }
                    if (i < op1 && j < op2) {
                        // Op1 then Op2
                        int afterOp1 = (x + 1) / 2;
                        if (afterOp1 >= k) {
                            next[i + 1][j + 1] = Math.min(next[i + 1][j + 1], cur + afterOp1 - k);
                        }
                        // Op2 then Op1
                        if (x >= k) {
                            int afterOp2 = x - k;
                            next[i + 1][j + 1] = Math.min(next[i + 1][j + 1], cur + (afterOp2 + 1) / 2);
                        }
                    }
                }
            }
            dp = next;
        }

        int ans = INF;
        for (int[] row : dp) {
            for (int v : row) {
                ans = Math.min(ans, v);
            }
        }
        return ans;
    }
}
