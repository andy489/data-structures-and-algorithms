# https://leetcode.com/problems/maximum-profit-of-operating-a-centennial-wheel/

class Solution:
    def minOperationsMaxProfit(self, customers: list[int], boardingCost: int, runningCost: int) -> int:
        waiting = max_profit = rotation = 0
        best_round = -1
        profit = 0
        i = 0
        while i < len(customers) or waiting > 0:
            if i < len(customers):
                waiting += customers[i]
            boarded = min(4, waiting)
            waiting -= boarded
            rotation += 1
            profit += boarded * boardingCost - runningCost
            if profit > max_profit:
                max_profit = profit
                best_round = rotation
            i += 1
        return best_round
