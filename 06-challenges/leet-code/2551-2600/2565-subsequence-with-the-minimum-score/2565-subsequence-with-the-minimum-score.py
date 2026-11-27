# https://leetcode.com/problems/subsequence-with-the-minimum-score/

# Solution: Prefix + Suffix Matching — O(n+m) time, O(n+m) space
class Solution:
    def minimumScore(self, s: str, t: str) -> int:
        n, m = len(s), len(t)

        # pre[i] = number of t chars matched using s[0..i] (prefix of t)
        pre = [0] * n
        j = 0
        for i in range(n):
            if j < m and s[i] == t[j]:
                j += 1
            pre[i] = j

        # suf[i] = number of t chars matched using s[i..n-1] (suffix of t)
        suf = [0] * n
        j = m - 1
        for i in range(n - 1, -1, -1):
            if j >= 0 and s[i] == t[j]:
                j -= 1
            suf[i] = m - 1 - j

        if pre[n - 1] == m:
            return 0

        ans = m
        for i in range(-1, n):
            prefix_matched = pre[i] if i >= 0 else 0
            suffix_matched = suf[i + 1] if i + 1 < n else 0
            removed = m - prefix_matched - suffix_matched
            ans = min(ans, max(0, removed))
        return ans
