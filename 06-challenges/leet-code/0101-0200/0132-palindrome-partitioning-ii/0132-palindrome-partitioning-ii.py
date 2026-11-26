# https://leetcode.com/problems/palindrome-partitioning-ii/

# Solution 1: DP + Expand-Around-Center — O(n²) time, O(n) space
class Solution:
    def minCut(self, s: str) -> int:
        n = len(s)
        cut = list(range(n))
        for c in range(n):
            for k in range(n):
                # odd
                l, r = c - k, c + k
                if l < 0 or r >= n or s[l] != s[r]:
                    break
                cut[r] = 0 if l == 0 else min(cut[r], cut[l - 1] + 1)
            for k in range(1, n):
                # even
                l, r = c - k + 1, c + k
                if l < 0 or r >= n or s[l] != s[r]:
                    break
                cut[r] = 0 if l == 0 else min(cut[r], cut[l - 1] + 1)
        return cut[n - 1]


# Solution 2: DP + 2-D Palindrome Table — O(n²) time, O(n²) space
class Solution2:
    def minCut(self, s: str) -> int:
        n = len(s)
        is_palin = [[False] * n for _ in range(n)]
        for i in range(n):
            is_palin[i][i] = True
        for i in range(n - 1):
            is_palin[i][i + 1] = (s[i] == s[i + 1])
        for length in range(3, n + 1):
            for i in range(n - length + 1):
                j = i + length - 1
                is_palin[i][j] = (s[i] == s[j]) and is_palin[i + 1][j - 1]
        cut = list(range(n))
        for i in range(n):
            if is_palin[0][i]:
                cut[i] = 0
                continue
            for j in range(1, i + 1):
                if is_palin[j][i]:
                    cut[i] = min(cut[i], cut[j - 1] + 1)
        return cut[n - 1]
