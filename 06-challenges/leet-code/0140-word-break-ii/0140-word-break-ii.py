# https://leetcode.com/problems/word-break-ii/

# Solution 1: Memoized DFS (Top-Down) — O(n·2ⁿ) time, O(n·2ⁿ) space
class Solution:
    def wordBreak(self, s: str, wordDict: list[str]) -> list[str]:
        words = set(wordDict)
        memo = {}

        def dfs(start: int) -> list[str]:
            if start in memo:
                return memo[start]
            if start == len(s):
                return [""]
            res = []
            for end in range(start + 1, len(s) + 1):
                word = s[start:end]
                if word in words:
                    for rest in dfs(end):
                        res.append(word if not rest else word + " " + rest)
            memo[start] = res
            return res

        return dfs(0)


# Solution 2: Bottom-Up DP — O(n·2ⁿ) time, O(n·2ⁿ) space
class Solution2:
    def wordBreak(self, s: str, wordDict: list[str]) -> list[str]:
        n = len(s)
        dp: list[list[str]] = [[] for _ in range(n + 1)]
        dp[0] = [""]
        for i in range(1, n + 1):
            for w in wordDict:
                l = len(w)
                if i >= l and s[i - l:i] == w and dp[i - l]:
                    for prev in dp[i - l]:
                        dp[i].append(w if not prev else prev + " " + w)
        return dp[n]
