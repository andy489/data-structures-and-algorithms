# https://leetcode.com/problems/minimum-number-of-removals-to-make-mountain-array/

class Solution:
    def minimumMountainRemovals(self, nums: list[int]) -> int:
        n = len(nums)
        lis = [1] * n
        lds = [1] * n
        for i in range(1, n):
            for j in range(i):
                if nums[j] < nums[i]:
                    lis[i] = max(lis[i], lis[j] + 1)
        for i in range(n - 2, -1, -1):
            for j in range(i + 1, n):
                if nums[j] < nums[i]:
                    lds[i] = max(lds[i], lds[j] + 1)
        max_mountain = max(
            lis[i] + lds[i] - 1
            for i in range(1, n - 1)
            if lis[i] > 1 and lds[i] > 1
        )
        return n - max_mountain
