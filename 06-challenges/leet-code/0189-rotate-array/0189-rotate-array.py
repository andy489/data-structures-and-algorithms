# https://leetcode.com/problems/rotate-array/

# Triple reverse — O(n) time, O(1) space
class Solution:
    def rotate(self, nums: list[int], k: int) -> None:
        n = len(nums)
        k %= n

        def rev(lo: int, hi: int) -> None:
            while lo < hi:
                nums[lo], nums[hi] = nums[hi], nums[lo]
                lo += 1
                hi -= 1

        rev(0, n - 1)
        rev(0, k - 1)
        rev(k, n - 1)
