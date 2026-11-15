# https://leetcode.com/problems/fibonacci-number/

# Solution: Naive Recursion — O(2^n) time, O(n) space
class Solution:
    def fib(self, n: int) -> int:
        if n <= 1:
            return n
        return self.fib(n - 1) + self.fib(n - 2)


# Solution 2: Recursive with Memoisation — O(n) time, O(n) space
class Solution2:
    def fib(self, n: int, memo: dict = {}) -> int:
        if n <= 1:
            return n
        if n not in memo:
            memo[n] = self.fib(n - 1, memo) + self.fib(n - 2, memo)
        return memo[n]


# Solution 3: Iterative DP — O(n) time, O(1) space
class Solution3:
    def fib(self, n: int) -> int:
        if n <= 1:
            return n
        prev, curr = 0, 1
        for _ in range(2, n + 1):
            prev, curr = curr, prev + curr
        return curr


# Solution 4: Matrix Exponentiation — O(log n) time, O(log n) space
class Solution4:
    def fib(self, n: int) -> int:
        if n <= 1:
            return n

        def matmul(a, b):
            return [
                [a[0][0] * b[0][0] + a[0][1] * b[1][0], a[0][0] * b[0][1] + a[0][1] * b[1][1]],
                [a[1][0] * b[0][0] + a[1][1] * b[1][0], a[1][0] * b[0][1] + a[1][1] * b[1][1]],
            ]

        def matpow(m, p):
            if p == 1:
                return m
            if p % 2 == 0:
                half = matpow(m, p // 2)
                return matmul(half, half)
            return matmul(m, matpow(m, p - 1))

        return matpow([[1, 1], [1, 0]], n)[0][1]
