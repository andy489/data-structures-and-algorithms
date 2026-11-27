# https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/

class Solution:
    def maxArea(self, h: int, w: int, horizontalCuts: list[int], verticalCuts: list[int]) -> int:
        MOD = 10**9 + 7
        horizontalCuts.sort()
        verticalCuts.sort()
        def max_gap(cuts, total):
            return max(cuts[0], total - cuts[-1], max(cuts[i]-cuts[i-1] for i in range(1,len(cuts))), default=0)
        maxH = max(horizontalCuts[0], h - horizontalCuts[-1], *(horizontalCuts[i]-horizontalCuts[i-1] for i in range(1,len(horizontalCuts))))
        maxW = max(verticalCuts[0], w - verticalCuts[-1], *(verticalCuts[i]-verticalCuts[i-1] for i in range(1,len(verticalCuts))))
        return maxH * maxW % MOD
