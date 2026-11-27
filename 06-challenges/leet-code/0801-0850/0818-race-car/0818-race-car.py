# https://leetcode.com/problems/race-car/

class Solution:
    def racecar(self, target: int) -> int:
        dp = [0] * (target + 1)
        for t in range(1, target + 1):
            k = t.bit_length()
            if t == (1 << k) - 1:
                dp[t] = k
                continue
            dp[t] = dp[(1 << k) - 1 - t] + k + 1
            for j in range(k - 1):
                back = (1 << j) - 1
                dp[t] = min(dp[t], dp[t - (1 << (k - 1)) + 1 + back] + k - 1 + j + 2)
        return dp[target]
