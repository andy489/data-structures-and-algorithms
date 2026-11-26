# https://leetcode.com/problems/find-if-array-can-be-sorted/

class Solution:
    def canSortArray(self, nums: list[int]) -> bool:
        prev_max = 0
        cur_min = cur_max = nums[0]
        cur_bits = bin(nums[0]).count('1')
        for x in nums[1:]:
            bits = bin(x).count('1')
            if bits == cur_bits:
                cur_min, cur_max = min(cur_min, x), max(cur_max, x)
            else:
                if cur_min < prev_max: return False
                prev_max = cur_max
                cur_min = cur_max = x
                cur_bits = bits
        return cur_min >= prev_max
