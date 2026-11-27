# https://leetcode.com/problems/container-with-most-water/

class Solution:
    def maxArea(self, height: list[int]) -> int:
        max_water = 0
        l, r = 0, len(height) - 1

        while l < r:
            h = min(height[l], height[r])
            max_water = max(max_water, (r - l) * h)
            while height[l] <= h and l < r:
                l += 1
            while height[r] <= h and l < r:
                r -= 1

        return max_water
