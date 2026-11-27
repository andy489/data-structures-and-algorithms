# https://leetcode.com/problems/substring-matching-pattern/
class Solution:
    def hasMatch(self, s: str, p: str) -> bool:
        star = p.index('*')
        prefix = p[:star]
        suffix = p[star + 1:]
        n = len(s)
        plen, slen = len(prefix), len(suffix)
        for i in range(n - plen + 1):
            if s[i:i + plen] == prefix:
                start = i + plen
                for j in range(start, n - slen + 1):
                    if s[j:j + slen] == suffix:
                        return True
        return False
