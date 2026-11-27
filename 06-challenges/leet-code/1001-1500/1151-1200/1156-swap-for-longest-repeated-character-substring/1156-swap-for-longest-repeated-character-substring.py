# https://leetcode.com/problems/swap-for-longest-repeated-character-substring/

class Solution:
    def maxRepOpt1(self, text: str) -> int:
        from collections import Counter
        count = Counter(text)
        # Build run-length encoding
        runs = []
        i, n = 0, len(text)
        while i < n:
            j = i
            while j < n and text[j] == text[i]:
                j += 1
            runs.append((text[i], j - i))
            i = j
        ans = 0
        for r, (ch, length) in enumerate(runs):
            best = min(length + 1, count[ch])
            if r + 2 < len(runs) and runs[r + 1][1] == 1 and runs[r + 2][0] == ch:
                merged = length + runs[r + 2][1] + 1
                best = max(best, min(merged, count[ch]))
            ans = max(ans, best)
        return ans
