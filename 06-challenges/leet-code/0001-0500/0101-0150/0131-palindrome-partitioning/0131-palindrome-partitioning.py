# https://leetcode.com/problems/palindrome-partitioning/

# Solution 1: Backtracking with inline palindrome check — O(n·2ⁿ) time, O(n) extra space
class Solution:
    def partition(self, s: str) -> list[list[str]]:
        res = []

        def backtrack(start: int, path: list[str]) -> None:
            if start == len(s):
                res.append(path[:])
                return
            for end in range(start, len(s)):
                sub = s[start:end + 1]
                if sub == sub[::-1]:
                    path.append(sub)
                    backtrack(end + 1, path)
                    path.pop()

        backtrack(0, [])
        return res


# Solution 2: Backtracking + DP palindrome table — O(n²) pre-computation, O(n·2ⁿ) backtracking
class Solution2:
    def partition(self, s: str) -> list[list[str]]:
        n = len(s)
        dp = [[False] * n for _ in range(n)]
        for i in range(n):
            dp[i][i] = True
        for i in range(n - 1):
            dp[i][i + 1] = (s[i] == s[i + 1])
        for length in range(3, n + 1):
            for i in range(n - length + 1):
                j = i + length - 1
                dp[i][j] = (s[i] == s[j]) and dp[i + 1][j - 1]

        res = []

        def backtrack(start: int, path: list[str]) -> None:
            if start == n:
                res.append(path[:])
                return
            for end in range(start, n):
                if dp[start][end]:
                    path.append(s[start:end + 1])
                    backtrack(end + 1, path)
                    path.pop()

        backtrack(0, [])
        return res
