# https://leetcode.com/problems/bitwise-ors-of-subarrays/

class Solution:
    def subarrayBitwiseORs(self, arr: list[int]) -> int:
        res, prev = set(), set()
        for x in arr:
            curr = {x | y for y in prev} | {x}
            res |= curr
            prev = curr
        return len(res)
