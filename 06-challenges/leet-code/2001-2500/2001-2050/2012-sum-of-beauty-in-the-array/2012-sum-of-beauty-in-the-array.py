# https://leetcode.com/problems/sum-of-beauty-in-the-array/

class Solution:
    def sumOfBeauties(self, nums: list[int]) -> int:
        n = len(nums)
        pref_max = [0] * n
        suf_min = [0] * n
        pref_max[0] = nums[0]
        for i in range(1, n):
            pref_max[i] = max(pref_max[i-1], nums[i])
        suf_min[-1] = nums[-1]
        for i in range(n-2, -1, -1):
            suf_min[i] = min(suf_min[i+1], nums[i])
        res = 0
        for i in range(1, n-1):
            if pref_max[i-1] < nums[i] < suf_min[i+1]:
                res += 2
            elif nums[i-1] < nums[i] < nums[i+1]:
                res += 1
        return res
