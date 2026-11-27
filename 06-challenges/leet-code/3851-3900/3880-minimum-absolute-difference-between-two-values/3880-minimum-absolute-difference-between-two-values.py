# https://leetcode.com/problems/minimum-absolute-difference-between-two-values/

class Solution:
    def minAbsDiff(self, nums: list[int]) -> int:
        ones = [i for i, x in enumerate(nums) if x == 1]
        twos = [i for i, x in enumerate(nums) if x == 2]
        if not ones or not twos:
            return -1
        ans = float('inf')
        i, j = 0, 0
        while i < len(ones) and j < len(twos):
            ans = min(ans, abs(ones[i] - twos[j]))
            if ones[i] < twos[j]:
                i += 1
            else:
                j += 1
        return ans
