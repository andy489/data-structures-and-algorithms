# https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/
class Solution:
    def minSwaps(self, s: str) -> int:
        unmatched = 0
        for c in s:
            if c == '[':
                unmatched -= 1
            else:
                unmatched += 1
            if unmatched < 0:
                unmatched = 0
        return (unmatched + 1) // 2
