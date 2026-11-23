# https://leetcode.com/problems/partition-equal-subset-sum/

class Solution:
    def canPartition(self, nums: list[int]) -> bool:
        total = sum(nums)
        if total % 2 != 0:
            return False
        target = total // 2
        reachable = [False] * (target + 1)
        reachable[0] = True
        for num in nums:
            for j in range(target, num - 1, -1):
                reachable[j] = reachable[j] or reachable[j - num]
        return reachable[target]
