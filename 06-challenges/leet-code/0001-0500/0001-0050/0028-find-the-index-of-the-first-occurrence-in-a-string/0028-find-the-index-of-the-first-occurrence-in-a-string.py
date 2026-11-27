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
# https://cp-algorithms.com/string/prefix-function.html
class Solution2:
    def strStr(self, haystack: str, needle: str) -> int:
        n, m = len(haystack), len(needle)
        lps = self._build_lps(needle)
        j = 0  # number of needle chars matched so far
        for i in range(n):
            # mismatch after j matches: fall back using lps to skip re-checking
            while j > 0 and haystack[i] != needle[j]:
                j = lps[j - 1]
            if haystack[i] == needle[j]:
                j += 1
            if j == m:  # full needle matched
                return i - m + 1
        return -1

    # lps[i] = length of longest proper prefix of needle[0..i] that is also a suffix
    def _build_lps(self, needle: str) -> list[int]:
        m = len(needle)
        lps = [0] * m
        length, i = 0, 1  # length = length of previous longest prefix-suffix
        while i < m:
            if needle[i] == needle[length]:
                length += 1
                lps[i] = length
                i += 1
            elif length > 0:
                length = lps[length - 1]  # try shorter prefix, don't advance i
            else:
                lps[i] = 0
                i += 1
        return lps


# Solution3: Z-Algorithm — O(n + m) time, O(n + m) space
# https://cp-algorithms.com/string/z-function.html
class Solution3:
    def strStr(self, haystack: str, needle: str) -> int:
        n, m = len(haystack), len(needle)
        # sentinel "$" ensures z-values never span the needle/haystack boundary
        s = needle + "$" + haystack
        z = self._build_z(s)
        for i in range(m + 1, len(s)):
            if z[i] >= m:
                return i - m - 1  # map back to haystack index
        return -1

    # z[i] = length of longest substring starting at s[i] matching a prefix of s
    def _build_z(self, s: str) -> list[int]:
        length = len(s)
        z = [0] * length
        l, r = 0, 0  # [l, r) = rightmost Z-box seen so far
        for i in range(1, length):
            if i < r:
                z[i] = min(r - i, z[i - l])  # reuse already-computed info
            while i + z[i] < length and s[z[i]] == s[i + z[i]]:
                z[i] += 1  # extend the match
            if i + z[i] > r:
                l, r = i, i + z[i]  # advance the Z-box
        return z
