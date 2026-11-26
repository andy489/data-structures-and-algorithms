# https://leetcode.com/problems/buildings-with-an-ocean-view/

class Solution:
    def findBuildings(self, heights: list[int]) -> list[int]:
        result = []
        max_right = 0
        for i in range(len(heights) - 1, -1, -1):
            if heights[i] > max_right:
                result.append(i)
                max_right = heights[i]
        return result[::-1]
