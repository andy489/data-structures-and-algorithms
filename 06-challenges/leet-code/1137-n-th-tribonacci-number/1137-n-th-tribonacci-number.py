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


# Solution 4: Matrix Exponentiation — O(log n) time, O(1) space
class Solution4:
    def tribonacci(self, n: int) -> int:
        if n == 0:
            return 0
        if n <= 2:
            return 1

        def matmul(a, b):
            s = len(a)
            c = [[0] * s for _ in range(s)]
            for i in range(s):
                for j in range(s):
                    for k in range(s):
                        c[i][j] += a[i][k] * b[k][j]
            return c

        def matpow(m, p):
            if p == 1:
                return m
            if p % 2 == 0:
                half = matpow(m, p // 2)
                return matmul(half, half)
            return matmul(m, matpow(m, p - 1))

        r = matpow([[1, 1, 1], [1, 0, 0], [0, 1, 0]], n - 2)
        return r[0][0] + r[0][1]
