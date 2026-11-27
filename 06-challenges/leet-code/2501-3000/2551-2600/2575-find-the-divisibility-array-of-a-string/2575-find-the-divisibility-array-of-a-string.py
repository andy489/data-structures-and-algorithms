# https://leetcode.com/problems/find-the-divisibility-array-of-a-string/

from typing import List

class Solution:
    def divisibilityArray(self, word: str, m: int) -> List[int]:
        remainder = 0
        result = []
        for ch in word:
            remainder = (remainder * 10 + int(ch)) % m
            result.append(1 if remainder == 0 else 0)
        return result
