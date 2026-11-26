# https://leetcode.com/problems/reverse-subarray-to-maximize-array-value/

class Solution:
    def maxValueAfterReverse(self, nums: list[int]) -> int:
        n = len(nums)
        base = sum(abs(nums[i]-nums[i+1]) for i in range(n-1))
        gain = 0
        for i in range(1, n-1):
            gain = max(gain, abs(nums[0]-nums[i+1]) - abs(nums[i]-nums[i+1]))
            gain = max(gain, abs(nums[-1]-nums[i-1]) - abs(nums[i]-nums[i-1]))
        for i in range(n-1):
            lo1, hi1 = min(nums[i], nums[i+1]), max(nums[i], nums[i+1])
            for j in range(i+1, n-1):
                lo2, hi2 = min(nums[j], nums[j+1]), max(nums[j], nums[j+1])
                gain = max(gain, 2*(min(hi1,hi2)-max(lo1,lo2)))
        return base + gain
