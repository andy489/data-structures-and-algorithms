# https://leetcode.com/problems/count-special-quadruplets/
class Solution:
    def countQuadruplets(self, nums: list[int]) -> int:
        n = len(nums)
        count = 0
        freq = {}
        for c in range(n - 2, 1, -1):
            for d in range(c + 1, n):
                key = nums[d] - nums[c]
                freq[key] = freq.get(key, 0) + 1
            for a in range(c - 1):
                for b in range(a + 1, c):
                    count += freq.get(nums[a] + nums[b], 0)
            freq.clear()
        return count
