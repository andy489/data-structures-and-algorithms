# https://leetcode.com/problems/number-of-good-ways-to-split-a-string/

class Solution:
    def numSplits(self, s: str) -> int:
        from collections import Counter
        right = Counter(s)
        left = Counter()
        result = 0
        for c in s:
            left[c] += 1
            right[c] -= 1
            if right[c] == 0:
                del right[c]
            if len(left) == len(right):
                result += 1
        return result
