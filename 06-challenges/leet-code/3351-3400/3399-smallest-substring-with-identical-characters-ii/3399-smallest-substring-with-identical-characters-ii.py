# https://leetcode.com/problems/smallest-substring-with-identical-characters-ii/

class Solution:
    def minLength(self, s: str, numOps: int) -> int:
        n = len(s)

        def can_achieve(max_len: int) -> bool:
            if max_len == 1:
                flips0 = sum(1 for i, c in enumerate(s) if c != str(i % 2))
                flips1 = n - flips0
                return min(flips0, flips1) <= numOps
            flips = 0
            i = 0
            while i < n:
                j = i
                while j < n and s[j] == s[i]:
                    j += 1
                flips += (j - i - 1) // max_len
                i = j
            return flips <= numOps

        lo, hi = 1, n
        while lo < hi:
            mid = (lo + hi) // 2
            if can_achieve(mid):
                hi = mid
            else:
                lo = mid + 1
        return lo
