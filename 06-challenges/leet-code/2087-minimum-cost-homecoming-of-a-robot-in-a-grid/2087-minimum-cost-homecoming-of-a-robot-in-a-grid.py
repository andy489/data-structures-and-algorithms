# https://leetcode.com/problems/minimum-cost-homecoming-of-a-robot-in-a-grid/

class Solution:
    def minCost(self, startPos: list[int], homePos: list[int], rowCosts: list[int], colCosts: list[int]) -> int:
        r, c = startPos
        hr, hc = homePos
        cost = 0
        dr = 1 if hr > r else -1
        dc = 1 if hc > c else -1
        row = r + dr
        while row != hr + dr:
            cost += rowCosts[row]
            row += dr
        col = c + dc
        while col != hc + dc:
            cost += colCosts[col]
            col += dc
        return cost
