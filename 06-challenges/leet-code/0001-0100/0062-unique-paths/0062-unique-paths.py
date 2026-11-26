# https://leetcode.com/problems/unique-paths/

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [1] * n
        for _ in range(1, m):
            for j in range(1, n):
                dp[j] += dp[j - 1]
        return dp[n - 1]


# Solution 2: Combinatorics — O(min(m,n)) time, O(1) space
class Solution2:
    def uniquePaths(self, m: int, n: int) -> int:
        k = min(m, n) - 1
        result = 1
        for i in range(k):
            result = result * (m + n - 2 - i) // (i + 1)
        return result
