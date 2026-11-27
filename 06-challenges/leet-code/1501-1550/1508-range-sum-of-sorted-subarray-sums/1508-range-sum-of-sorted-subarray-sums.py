# https://leetcode.com/problems/range-sum-of-sorted-subarray-sums/

class Solution:
    def rangeSum(self, nums, n: int, left: int, right: int) -> int:
        MOD = 10 ** 9 + 7
        sums = []
        for i in range(n):
            cur = 0
            for j in range(i, n):
                cur += nums[j]
                sums.append(cur)
        sums.sort()
        return sum(sums[left - 1:right]) % MOD
