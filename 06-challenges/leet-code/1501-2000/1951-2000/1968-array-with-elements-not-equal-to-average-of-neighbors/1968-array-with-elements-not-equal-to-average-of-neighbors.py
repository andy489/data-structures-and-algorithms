# https://leetcode.com/problems/array-with-elements-not-equal-to-average-of-neighbors/
class Solution:
    def rearrangeArray(self, nums: list[int]) -> list[int]:
        nums.sort()
        n = len(nums)
        ans = [0] * n
        lo, hi = 0, (n + 1) // 2
        for i in range(n):
            if i % 2 == 0:
                ans[i] = nums[lo]
                lo += 1
            else:
                ans[i] = nums[hi]
                hi += 1
        return ans
