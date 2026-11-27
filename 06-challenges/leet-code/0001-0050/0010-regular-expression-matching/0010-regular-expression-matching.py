# https://leetcode.com/problems/regular-expression-matching/

class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        n, m = len(s), len(p)
        cache = {}

        def dfs(i: int, j: int) -> bool:
            if j >= m:
                return i >= n
            if (i, j) in cache:
                return cache[(i, j)]
            matched = i < n and (s[i] == p[j] or p[j] == '.')
            if j + 1 < m and p[j + 1] == '*':
                result = dfs(i, j + 2) or (matched and dfs(i + 1, j))
            else:
                result = matched and dfs(i + 1, j + 1)
            cache[(i, j)] = result
            return result

        return dfs(0, 0)
