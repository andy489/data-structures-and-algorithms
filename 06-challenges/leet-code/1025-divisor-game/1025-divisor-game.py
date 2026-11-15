# https://leetcode.com/problems/divisor-game/

# Solution: Math — O(1) time, O(1) space
class Solution:
    def divisorGame(self, n: int) -> bool:
        return n % 2 == 0


# Solution 2: Dynamic Programming — O(n²) time, O(n) space
class Solution2:
    def divisorGame(self, n: int) -> bool:
        dp = [False] * (n + 1)
        for i in range(2, n + 1):
            for x in range(1, i):
                if i % x == 0 and not dp[i - x]:
                    dp[i] = True
                    break
        return dp[n]
