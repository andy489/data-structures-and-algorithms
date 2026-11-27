# https://leetcode.com/problems/sum-of-even-numbers-after-queries/

class Solution:
    def sumEvenAfterQueries(self, nums: list[int], queries: list[list[int]]) -> list[int]:
        even_sum = sum(x for x in nums if x % 2 == 0)
        res = []
        for val, idx in queries:
            if nums[idx] % 2 == 0:
                even_sum -= nums[idx]
            nums[idx] += val
            if nums[idx] % 2 == 0:
                even_sum += nums[idx]
            res.append(even_sum)
        return res
