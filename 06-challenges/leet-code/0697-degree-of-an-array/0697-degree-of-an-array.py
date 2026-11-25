# https://leetcode.com/problems/degree-of-an-array/

class Solution:
    def findShortestSubArray(self, nums: list) -> int:
        count, first, last = {}, {}, {}
        for i, v in enumerate(nums):
            count[v] = count.get(v, 0) + 1
            if v not in first:
                first[v] = i
            last[v] = i
        degree = max(count.values())
        return min(last[v] - first[v] + 1 for v in count if count[v] == degree)
