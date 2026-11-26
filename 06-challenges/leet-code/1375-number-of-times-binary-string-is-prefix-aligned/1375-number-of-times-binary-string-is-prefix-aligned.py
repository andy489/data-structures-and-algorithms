# https://leetcode.com/problems/number-of-times-binary-string-is-prefix-aligned/

class Solution:
    def numTimesAllBlue(self, flips: list[int]) -> int:
        max_flipped = count = 0
        for i, f in enumerate(flips, 1):
            max_flipped = max(max_flipped, f)
            if max_flipped == i:
                count += 1
        return count
