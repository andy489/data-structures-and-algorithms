# https://leetcode.com/problems/count-indices-with-opposite-parity/
from typing import List


class Solution:
    def countIndices(self, nums: List[int]) -> List[int]:
        odd_count = sum(1 for v in nums if v % 2 == 1)
        even_count = len(nums) - odd_count
        answer = []
        seen_odd, seen_even = 0, 0
        for v in nums:
            if v % 2 == 0:
                seen_even += 1
            else:
                seen_odd += 1
            remaining_odd = odd_count - seen_odd
            remaining_even = even_count - seen_even
            if v % 2 == 0:
                answer.append(remaining_odd)
            else:
                answer.append(remaining_even)
        return answer
