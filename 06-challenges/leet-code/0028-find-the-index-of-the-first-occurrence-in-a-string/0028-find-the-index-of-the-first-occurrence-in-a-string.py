# https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/

# Solution: Sliding Window — O(n·m) time, O(1) space
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        n, m = len(haystack), len(needle)
        for i in range(n - m + 1):
            if haystack[i:i + m] == needle:
                return i
        return -1


# Solution2: KMP — O(n + m) time, O(m) space
class Solution2:
    def strStr(self, haystack: str, needle: str) -> int:
        n, m = len(haystack), len(needle)
        lps = self._build_lps(needle)
        j = 0
        for i in range(n):
            while j > 0 and haystack[i] != needle[j]:
                j = lps[j - 1]
            if haystack[i] == needle[j]:
                j += 1
            if j == m:
                return i - m + 1
        return -1

    def _build_lps(self, needle: str) -> list[int]:
        m = len(needle)
        lps = [0] * m
        length, i = 0, 1
        while i < m:
            if needle[i] == needle[length]:
                length += 1
                lps[i] = length
                i += 1
            elif length > 0:
                length = lps[length - 1]
            else:
                lps[i] = 0
                i += 1
        return lps
