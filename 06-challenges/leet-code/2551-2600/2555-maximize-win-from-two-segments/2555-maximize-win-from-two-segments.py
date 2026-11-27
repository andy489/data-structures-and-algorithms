# https://leetcode.com/problems/maximize-win-from-two-segments/

# Solution: Sliding Window + DP — O(n) time, O(n) space
class Solution:
    def maximizeWin(self, prizePositions: list[int], k: int) -> int:
        n = len(prizePositions)
        dp = [0] * (n + 1)  # dp[i] = max prizes from one segment using indices 0..i-1
        ans = 0
        l = 0
        for r in range(n):
            while prizePositions[r] - prizePositions[l] > k:
                l += 1
            window_size = r - l + 1
            dp[r + 1] = max(dp[r], window_size)
            ans = max(ans, dp[l] + window_size)
        return ans
