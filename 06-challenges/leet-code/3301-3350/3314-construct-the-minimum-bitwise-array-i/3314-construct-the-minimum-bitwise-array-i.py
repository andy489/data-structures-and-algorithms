# https://leetcode.com/problems/construct-the-minimum-bitwise-array-i/

from typing import List


class Solution:
    def minBitwiseArray(self, nums: List[int]) -> List[int]:
        ans = []
        for p in nums:
            if p == 2:
                ans.append(-1)
                continue
            found = -1
            for bit in range(1, 30):
                if not (p >> bit & 1):
                    x = p ^ (1 << bit)
                    if (x | (x + 1)) == p:
                        found = x
                        break
            ans.append(found)
        return ans
