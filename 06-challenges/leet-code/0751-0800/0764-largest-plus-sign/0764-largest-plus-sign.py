# https://leetcode.com/problems/largest-plus-sign/

class Solution:
    def orderOfLargestPlusSign(self, n: int, mines: list[list[int]]) -> int:
        mineSet = {(r, c) for r, c in mines}
        dp = [[0] * n for _ in range(n)]
        ans = 0
        for r in range(n):
            cnt = 0
            for c in range(n):
                cnt = 0 if (r, c) in mineSet else cnt + 1
                dp[r][c] = cnt
            cnt = 0
            for c in range(n - 1, -1, -1):
                cnt = 0 if (r, c) in mineSet else cnt + 1
                dp[r][c] = min(dp[r][c], cnt)
        for c in range(n):
            cnt = 0
            for r in range(n):
                cnt = 0 if (r, c) in mineSet else cnt + 1
                dp[r][c] = min(dp[r][c], cnt)
            cnt = 0
            for r in range(n - 1, -1, -1):
                cnt = 0 if (r, c) in mineSet else cnt + 1
                dp[r][c] = min(dp[r][c], cnt)
                ans = max(ans, dp[r][c])
        return ans
