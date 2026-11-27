# https://leetcode.com/problems/mirror-frequency-distance/
class Solution:
    def mirrorFrequencyDistance(self, s: str) -> int:
        from collections import Counter
        freq = Counter(s)

        result = 0

        # Letter pairs: (a,z), (b,y), ..., (m,n) — 13 pairs
        for i in range(13):
            c = chr(ord('a') + i)
            m = chr(ord('z') - i)
            result += abs(freq.get(c, 0) - freq.get(m, 0))

        # Digit pairs: (0,9), (1,8), ..., (4,5) — 5 pairs
        for i in range(5):
            c = chr(ord('0') + i)
            m = chr(ord('9') - i)
            result += abs(freq.get(c, 0) - freq.get(m, 0))

        return result
