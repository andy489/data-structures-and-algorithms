# https://leetcode.com/problems/next-greater-numerically-balanced-number/

class Solution:
    def nextBeautifulNumber(self, n: int) -> int:
        from collections import Counter
        def is_balanced(x):
            freq = Counter(str(x))
            return all(int(d) == cnt for d, cnt in freq.items())
        cand = n + 1
        while not is_balanced(cand):
            cand += 1
        return cand
