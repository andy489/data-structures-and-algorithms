# https://leetcode.com/problems/two-sum-less-than-k/

class Solution:
    def twoSumLessThanK(self, nums: list[int], k: int) -> int:
        nums.sort()
        l, r, best = 0, len(nums)-1, -1
        while l < r:
            s = nums[l] + nums[r]
            if s < k:
                best = max(best, s)
                l += 1
            else:
                r -= 1
        return best
