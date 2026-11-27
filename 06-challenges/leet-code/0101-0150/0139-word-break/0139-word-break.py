# https://leetcode.com/problems/word-break/

# Solution 1: Bottom-Up DP — O(n²·m) time, O(n) space
class Solution:
    def wordBreak(self, s: str, wordDict: list[str]) -> bool:
        words = set(wordDict)
        n = len(s)
        dp = [False] * (n + 1)
        dp[0] = True
        for i in range(1, n + 1):
            for w in words:
                l = len(w)
                if i >= l and dp[i - l] and s[i - l:i] == w:
                    dp[i] = True
                    break
        return dp[n]


# Solution 2: Top-Down Memoized DFS — O(n²) time, O(n) space
class Solution2:
    def wordBreak(self, s: str, wordDict: list[str]) -> bool:
        words = set(wordDict)
        memo = {}

        def dfs(start: int) -> bool:
            if start == len(s):
                return True
            if start in memo:
                return memo[start]
            for end in range(start + 1, len(s) + 1):
                if s[start:end] in words and dfs(end):
                    memo[start] = True
                    return True
            memo[start] = False
            return False

        return dfs(0)
