# https://leetcode.com/problems/contains-duplicate-ii/

class Solution:
    def containsNearbyDuplicate(self, nums: list[int], k: int) -> bool:
        window: set[int] = set()
        for i, num in enumerate(nums):
            if num in window:
                return True
            window.add(num)
            if len(window) > k:
                window.remove(nums[i - k])
        return False
