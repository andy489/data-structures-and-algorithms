# https://leetcode.com/problems/select-k-disjoint-special-substrings/

class Solution:
    def maxSubstringLength(self, s: str, k: int) -> bool:
        n = len(s)
        first = {}
        last = {}
        for i, c in enumerate(s):
            if c not in first:
                first[c] = i
            last[c] = i

        intervals = []
        used = set()
        for c in first:
            if c in used:
                continue
            lo, hi = first[c], last[c]
            changed = True
            while changed:
                changed = False
                for i in range(lo, hi + 1):
                    cc = s[i]
                    if first[cc] < lo:
                        lo = first[cc]
                        changed = True
                    if last[cc] > hi:
                        hi = last[cc]
                        changed = True
            if lo == 0 and hi == n - 1:
                continue
            for i in range(lo, hi + 1):
                used.add(s[i])
            intervals.append((lo, hi))

        intervals.sort(key=lambda x: x[1])
        count = 0
        prev_end = -1
        for lo, hi in intervals:
            if lo > prev_end:
                count += 1
                prev_end = hi
        return count >= k
