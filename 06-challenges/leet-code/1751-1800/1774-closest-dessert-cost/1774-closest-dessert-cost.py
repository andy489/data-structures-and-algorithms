# https://leetcode.com/problems/closest-dessert-cost/

class Solution:
    def closestCost(self, baseCosts: list[int], toppingCosts: list[int], target: int) -> int:
        self.ans = float('inf')

        def dfs(idx: int, cost: int) -> None:
            if abs(cost - target) < abs(self.ans - target) or \
               (abs(cost - target) == abs(self.ans - target) and cost < self.ans):
                self.ans = cost
            if idx == len(toppingCosts) or cost >= target:
                return
            for k in range(3):
                dfs(idx + 1, cost + k * toppingCosts[idx])

        for base in baseCosts:
            dfs(0, base)
        return self.ans
