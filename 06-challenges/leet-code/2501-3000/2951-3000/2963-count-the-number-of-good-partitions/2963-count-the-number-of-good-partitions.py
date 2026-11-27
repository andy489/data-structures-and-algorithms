# https://leetcode.com/problems/count-the-number-of-good-partitions/
class Solution:
    def numberOfGoodPartitions(self, nums: list[int]) -> int:
        MOD = 10 ** 9 + 7
        last = {x: i for i, x in enumerate(nums)}
        cuts = 0
        min_end = 0
        for i in range(len(nums) - 1):
            min_end = max(min_end, last[nums[i]])
            if i == min_end:
                cuts += 1
        return pow(2, cuts, MOD)
