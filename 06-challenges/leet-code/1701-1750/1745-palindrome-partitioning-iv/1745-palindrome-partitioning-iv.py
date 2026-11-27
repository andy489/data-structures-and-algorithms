# https://leetcode.com/problems/palindrome-partitioning-iv/

class Solution:
    def checkPartitioning(self, s: str) -> bool:
        n = len(s)
        is_palin = [[False] * n for _ in range(n)]
        for i in range(n - 1, -1, -1):
            for j in range(i, n):
                if s[i] == s[j] and (j - i <= 2 or is_palin[i + 1][j - 1]):
                    is_palin[i][j] = True
        for i in range(1, n - 1):
            for j in range(i, n - 1):
                if is_palin[0][i - 1] and is_palin[i][j] and is_palin[j + 1][n - 1]:
                    return True
        return False
