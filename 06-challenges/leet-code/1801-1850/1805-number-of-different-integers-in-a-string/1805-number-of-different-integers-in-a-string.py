# https://leetcode.com/problems/number-of-different-integers-in-a-string/

import re

class Solution:
    def numDifferentIntegers(self, word: str) -> int:
        nums = re.findall(r'\d+', word)
        return len(set(int(n) for n in nums))
