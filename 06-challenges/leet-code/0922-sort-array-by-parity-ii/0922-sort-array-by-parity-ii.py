# https://leetcode.com/problems/sort-array-by-parity-ii/

class Solution:
    def sortArrayByParityII(self, nums: list) -> list:
        odd = 1
        for even in range(0, len(nums), 2):
            if nums[even] % 2 == 1:
                while nums[odd] % 2 == 1:
                    odd += 2
                nums[even], nums[odd] = nums[odd], nums[even]
        return nums
