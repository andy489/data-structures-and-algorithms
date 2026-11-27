# https://leetcode.com/problems/minimum-total-space-wasted-with-k-resizing-operations/
class Solution:
    def minSpaceWastedKResizing(self, nums: list[int], k: int) -> int:
        n = len(nums)
        INF = float('inf')
        prefix = [0] * (n + 1)
        for i in range(n):
            prefix[i + 1] = prefix[i] + nums[i]

        dp = [[INF] * (k + 2) for _ in range(n + 1)]
        dp[0][0] = 0

        for i in range(1, n + 1):
            for j in range(1, k + 2):
                max_val = 0
                for l in range(i, 0, -1):
                    max_val = max(max_val, nums[l - 1])
                    s = prefix[i] - prefix[l - 1]
                    waste = max_val * (i - l + 1) - s
                    if dp[l - 1][j - 1] != INF:
                        dp[i][j] = min(dp[i][j], dp[l - 1][j - 1] + waste)

        return min(dp[n][1:k + 2])
