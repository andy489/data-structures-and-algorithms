// https://leetcode.com/problems/maximum-students-taking-exam/

// Solution: Bitmask DP — O(m * 4^n) time, O(m * 2^n) space
class Solution {
    public int maxStudents(char[][] seats) {
        int m = seats.length, n = seats[0].length;
        int[] valid = new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (seats[i][j] == '.') valid[i] |= (1 << j);
            }
        }
        int[][] dp = new int[m+1][1<<n];
        for (int[] row : dp) Arrays.fill(row, -1);
        dp[0][0] = 0;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int prev = 0; prev < (1<<n); prev++) {
                if (dp[i][prev] < 0) continue;
                for (int cur = 0; cur < (1<<n); cur++) {
                    if ((cur & valid[i]) != cur) continue;
                    if ((cur & (cur>>1)) != 0) continue;
                    if ((prev & (cur<<1)) != 0 || (prev & (cur>>1)) != 0) continue;
                    int students = dp[i][prev] + Integer.bitCount(cur);
                    if (dp[i+1][cur] < students) {
                        dp[i+1][cur] = students;
                        ans = Math.max(ans, students);
                    }
                }
            }
        }
        return ans;
    }
}
