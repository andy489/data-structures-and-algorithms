# https://leetcode.com/problems/wiggle-sort-ii/

class Solution:
    def wiggleSort(self, nums: list[int]) -> None:
        n = len(nums)
        sorted_nums = sorted(nums)
        mid = (n - 1) // 2
        large = n - 1
        for i in range(n):
            if i % 2 == 0:
                nums[i] = sorted_nums[mid]
                mid -= 1
            else:
                nums[i] = sorted_nums[large]
                large -= 1
