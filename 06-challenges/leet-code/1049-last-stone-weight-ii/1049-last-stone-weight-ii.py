# https://leetcode.com/problems/last-stone-weight-ii/

class Solution:
    def lastStoneWeightII(self, stones: list[int]) -> int:
        total = sum(stones)
        target = total // 2
        dp = {0}
        for s in stones:
            dp = {x + s for x in dp} | dp
        return min(abs(total - 2*x) for x in dp if x <= target + 1)
