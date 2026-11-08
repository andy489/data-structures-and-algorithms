# https://leetcode.com/problems/remove-duplicates-from-sorted-array/

# Solution: Two Pointers — O(n) time, O(1) space
class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        k = 1
        for i in range(1, len(nums)):
            if nums[i] != nums[k - 1]:
                nums[k] = nums[i]
                k += 1
        return k
