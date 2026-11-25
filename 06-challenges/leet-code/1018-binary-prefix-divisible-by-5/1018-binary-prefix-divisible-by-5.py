# https://leetcode.com/problems/binary-prefix-divisible-by-5/

class Solution:
    def prefixesDivBy5(self, nums: list[int]) -> list[bool]:
        cur, result = 0, []
        for b in nums:
            cur = (cur * 2 + b) % 5
            result.append(cur == 0)
        return result
