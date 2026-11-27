# https://leetcode.com/problems/super-egg-drop/

class Solution:
    def superEggDrop(self, k: int, n: int) -> int:
        dp = [0] * (k + 1)
        t = 0
        while dp[k] < n:
            t += 1
            for j in range(k, 0, -1):
                dp[j] = dp[j - 1] + dp[j] + 1
        return t
