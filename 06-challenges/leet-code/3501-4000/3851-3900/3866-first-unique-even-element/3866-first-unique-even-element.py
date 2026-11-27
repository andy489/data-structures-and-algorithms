# https://leetcode.com/problems/first-unique-even-element/

from collections import Counter
from typing import List

class Solution:
    def firstUniqueEvenElement(self, nums: List[int]) -> int:
        freq = Counter(nums)
        for n in nums:
            if n % 2 == 0 and freq[n] == 1:
                return n
        return -1
