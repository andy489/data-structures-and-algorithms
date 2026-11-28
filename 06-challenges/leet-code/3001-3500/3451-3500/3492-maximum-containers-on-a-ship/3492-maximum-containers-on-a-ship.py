# https://leetcode.com/problems/maximum-containers-on-a-ship/

class Solution:
    def maxContainers(self, n: int, w: int, maxWeight: int) -> int:
        return min(n * n, maxWeight // w)
