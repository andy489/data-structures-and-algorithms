# https://leetcode.com/problems/form-array-by-concatenating-subarrays-of-another-array/

class Solution:
    def canChoose(self, groups: list[list[int]], nums: list[int]) -> bool:
        pos = 0
        for g in groups:
            gl = len(g)
            found = False
            while pos + gl <= len(nums):
                if nums[pos:pos + gl] == g:
                    pos += gl
                    found = True
                    break
                pos += 1
            if not found:
                return False
        return True
