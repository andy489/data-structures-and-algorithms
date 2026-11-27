# https://leetcode.com/problems/count-substrings-that-differ-by-one-character/

class Solution:
    def countSubstrings(self, s: str, t: str) -> int:
        m, n, ans = len(s), len(t), 0
        for i in range(m):
            for j in range(n):
                if s[i] != t[j]:
                    left = 0
                    while i - left - 1 >= 0 and j - left - 1 >= 0 and s[i - left - 1] == t[j - left - 1]:
                        left += 1
                    right = 0
                    while i + right + 1 < m and j + right + 1 < n and s[i + right + 1] == t[j + right + 1]:
                        right += 1
                    ans += (left + 1) * (right + 1)
        return ans
