# https://leetcode.com/problems/longest-duplicate-substring/

class Solution:
    def longestDupSubstring(self, s: str) -> str:
        n = len(s)
        MOD = (1 << 61) - 1
        BASE = 31

        def check(length):
            pw = pow(BASE, length, MOD)
            h = 0
            for c in s[:length]:
                h = (h * BASE + ord(c) - ord('a') + 1) % MOD
            seen = {h: [0]}
            for i in range(length, n):
                h = (h * BASE + ord(s[i]) - ord('a') + 1 - pw * (ord(s[i-length]) - ord('a') + 1)) % MOD
                sub = s[i-length+1:i+1]
                if h in seen:
                    for pos in seen[h]:
                        if s[pos:pos+length] == sub:
                            return sub
                seen.setdefault(h, []).append(i-length+1)
            return None

        lo, hi, res = 1, n-1, ""
        while lo <= hi:
            mid = (lo + hi) // 2
            dup = check(mid)
            if dup:
                res = dup; lo = mid + 1
            else:
                hi = mid - 1
        return res
