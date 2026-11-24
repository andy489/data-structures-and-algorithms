# https://leetcode.com/problems/maximum-distance-in-arrays/

class Solution:
    def maxDistance(self, arrays: list[list[int]]) -> int:
        global_min = arrays[0][0]
        global_max = arrays[0][-1]
        result = 0
        for i in range(1, len(arrays)):
            first, last = arrays[i][0], arrays[i][-1]
            result = max(result, last - global_min, global_max - first)
            global_min = min(global_min, first)
            global_max = max(global_max, last)
        return result
