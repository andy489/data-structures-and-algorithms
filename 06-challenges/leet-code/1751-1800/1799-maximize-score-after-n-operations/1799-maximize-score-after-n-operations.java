// https://leetcode.com/problems/maximize-score-after-n-operations/

// Solution: Bitmask DP — O(4^n * n) time, O(2^(2n)) space
class Solution {
    public int maxScore(int[] nums) {
        int m = nums.length;
        int[] dp = new int[1 << m];
        int[][] gcds = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                gcds[i][j] = gcd(nums[i], nums[j]);
            }
        }
        for (int mask = 0; mask < (1 << m); mask++) {
            int cnt = Integer.bitCount(mask);
            if (cnt % 2 != 0) {
                continue;
            }
            int op = cnt / 2 + 1;
            for (int i = 0; i < m; i++) {
                if ((mask & (1 << i)) == 0) {
                    continue;
                }
                for (int j = i + 1; j < m; j++) {
                    if ((mask & (1 << j)) == 0) {
                        continue;
                    }
                    int prev = mask ^ (1 << i) ^ (1 << j);
                    dp[mask] = Math.max(dp[mask], dp[prev] + op * gcds[i][j]);
                }
            }
        }
        return dp[(1 << m) - 1];
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}
