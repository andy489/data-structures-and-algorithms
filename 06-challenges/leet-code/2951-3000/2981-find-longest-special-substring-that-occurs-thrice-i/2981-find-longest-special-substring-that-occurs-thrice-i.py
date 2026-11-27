# https://leetcode.com/problems/find-longest-special-substring-that-occurs-thrice-i/
class Solution:
    def maximumLength(self, s: str) -> int:
        from collections import defaultdict
        # Count runs for each character
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
            for length in range(1, max(run_lengths) + 1):
                count = sum(max(0, r - length + 1) for r in run_lengths)
                if count >= 3:
                    result = max(result, length)
        return result
