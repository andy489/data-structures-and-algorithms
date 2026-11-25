# https://leetcode.com/problems/repeated-string-match/

import math

class Solution:
    def repeatedStringMatch(self, a: str, b: str) -> int:
        count = math.ceil(len(b) / len(a))
        repeated = a * count
        if b in repeated:
            return count
        if b in repeated + a:
            return count + 1
        return -1
