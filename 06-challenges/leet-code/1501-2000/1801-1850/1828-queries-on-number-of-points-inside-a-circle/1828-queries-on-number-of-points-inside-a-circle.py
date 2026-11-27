# https://leetcode.com/problems/queries-on-number-of-points-inside-a-circle/

class Solution:
    def countPoints(self, points: list[list[int]], queries: list[list[int]]) -> list[int]:
        ans = []
        for cx, cy, r in queries:
            cnt = sum((px - cx) ** 2 + (py - cy) ** 2 <= r * r for px, py in points)
            ans.append(cnt)
        return ans
