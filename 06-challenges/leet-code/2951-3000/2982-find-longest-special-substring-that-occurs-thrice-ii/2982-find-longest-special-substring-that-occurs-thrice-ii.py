# https://leetcode.com/problems/find-longest-special-substring-that-occurs-thrice-ii/
class Solution:
    def maximumLength(self, s: str) -> int:
        from collections import defaultdict
        runs = defaultdict(list)
        i = 0
        while i < len(s):
            j = i
            while j < len(s) and s[j] == s[i]:
                j += 1
            runs[s[i]].append(j - i)
            i = j

        result = -1
        for c, run_lengths in runs.items():
            lo, hi = 1, max(run_lengths)
            while lo <= hi:
                mid = (lo + hi) // 2
                count = sum(max(0, r - mid + 1) for r in run_lengths)
                if count >= 3:
                    result = max(result, mid)
                    lo = mid + 1
                else:
                    hi = mid - 1
        return result
