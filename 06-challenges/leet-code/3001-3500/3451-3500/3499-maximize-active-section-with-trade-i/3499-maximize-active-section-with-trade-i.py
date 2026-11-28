# https://leetcode.com/problems/maximize-active-section-with-trade-i/

class Solution:
    def maxActiveSectionsAfterTrade(self, s: str) -> int:
        total_ones = s.count('1')

        # Augment string with '1' at both ends
        t = '1' + s + '1'

        # Build run-length encoding
        runs = []
        i = 0
        while i < len(t):
            c = t[i]
            start = i
            while i < len(t) and t[i] == c:
                i += 1
            runs.append((c, i - start))

        best_gain = 0
        # Find triplets: 0-run, 1-run, 0-run (not at augmented ends)
        for idx in range(1, len(runs) - 1):
            if runs[idx][0] == '1' and runs[idx - 1][0] == '0' and runs[idx + 1][0] == '0':
                gain = runs[idx - 1][1] + runs[idx + 1][1]
                best_gain = max(best_gain, gain)

        return total_ones + best_gain
