# https://leetcode.com/problems/minimum-sideway-jumps/

class Solution:
    def minSideJumps(self, obstacles: list[int]) -> int:
        dp = [1, 0, 1]  # lanes 1, 2, 3 (0-indexed)
        for obs in obstacles[1:]:
            o = obs - 1  # 0-indexed, -1 means no obstacle
            if o >= 0:
                dp[o] = float('inf')
            min_cost = min(dp)
            for lane in range(3):
                if lane != o:
                    dp[lane] = min(dp[lane], min_cost + 1)
        return min(dp)
