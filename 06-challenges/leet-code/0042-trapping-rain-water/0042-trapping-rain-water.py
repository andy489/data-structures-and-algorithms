# https://leetcode.com/problems/trapping-rain-water/

class Solution:
    def trap(self, height: list[int]) -> int:
        l, r = 0, len(height) - 1
        max_l = max_r = water = 0
        while l < r:
            if max_l <= max_r:
                max_l = max(max_l, height[l])
                water += max_l - height[l]
                l += 1
            else:
                max_r = max(max_r, height[r])
                water += max_r - height[r]
                r -= 1
        return water
