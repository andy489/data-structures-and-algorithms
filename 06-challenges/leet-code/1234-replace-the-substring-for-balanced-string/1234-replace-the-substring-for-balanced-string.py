# https://leetcode.com/problems/replace-the-substring-for-balanced-string/

class Solution:
    def balancedString(self, s: str) -> int:
        n, k = len(s), len(s) // 4
        from collections import Counter
        count = Counter(s)
        if all(count[c] == k for c in 'QWER'): return 0
        res, l = n, 0
        for r, c in enumerate(s):
            count[c] -= 1
            while l <= r and all(count[x] <= k for x in 'QWER'):
                res = min(res, r - l + 1)
                count[s[l]] += 1
                l += 1
        return res
