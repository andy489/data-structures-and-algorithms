# https://leetcode.com/problems/unique-binary-search-trees/

# Solution: Dynamic Programming (Catalan Number) — O(n²) time, O(n) space
class Solution:
    def numTrees(self, n: int) -> int:
        dp = [0] * (n + 1)
        dp[0] = dp[1] = 1
        for k in range(2, n + 1):
            for i in range(1, k + 1):
                dp[k] += dp[i - 1] * dp[k - i]
        return dp[n]


# Solution 2: Closed-Form Catalan Number — O(n) time, O(1) space
class Solution2:
    def numTrees(self, n: int) -> int:
        result = 1
        for i in range(n):
            result = result * (2 * n - i) // (i + 1)
        return result // (n + 1)
