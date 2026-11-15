# https://leetcode.com/problems/n-th-tribonacci-number/

# Solution: Naive Recursion — O(3^n) time, O(n) space
class Solution:
    def tribonacci(self, n: int) -> int:
        if n == 0:
            return 0
        if n <= 2:
            return 1
        return self.tribonacci(n - 1) + self.tribonacci(n - 2) + self.tribonacci(n - 3)


# Solution 2: Recursive with Memoisation — O(n) time, O(n) space
class Solution2:
    def tribonacci(self, n: int, memo: dict = {}) -> int:
        if n == 0:
            return 0
        if n <= 2:
            return 1
        if n not in memo:
            memo[n] = self.tribonacci(n - 1, memo) + self.tribonacci(n - 2, memo) + self.tribonacci(n - 3, memo)
        return memo[n]


# Solution 3: Iterative DP with Rolling Array — O(n) time, O(1) space
class Solution3:
    SIZE = 4

    def tribonacci(self, n: int) -> int:
        if n == 0:
            return 0
        dp = [0] * self.SIZE
        dp[1] = dp[2] = 1
        for i in range(3, n + 1):
            dp[i % self.SIZE] = dp[(i - 1) % self.SIZE] + dp[(i - 2) % self.SIZE] + dp[(i - 3) % self.SIZE]
        return dp[n % self.SIZE]
