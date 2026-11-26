# https://leetcode.com/problems/increasing-decreasing-string/

from collections import Counter

class Solution:
    def sortString(self, s: str) -> str:
        cnt = Counter(s)
        res = []
        chars = sorted(cnt.keys())
        while len(res) < len(s):
            for c in chars:
                if cnt[c] > 0:
                    res.append(c); cnt[c] -= 1
            for c in reversed(chars):
                if cnt[c] > 0:
                    res.append(c); cnt[c] -= 1
        return ''.join(res)
