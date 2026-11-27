# https://leetcode.com/problems/shopping-offers/

from functools import lru_cache

class Solution:
    def shoppingOffers(self, price: list[int], special: list[list[int]], needs: list[int]) -> int:
        @lru_cache(maxsize=None)
        def dfs(remaining):
            cost = sum(remaining[i] * price[i] for i in range(len(price)))
            for offer in special:
                new_remaining = []
                applicable = True
                for i in range(len(price)):
                    diff = remaining[i] - offer[i]
                    if diff < 0:
                        applicable = False
                        break
                    new_remaining.append(diff)
                if applicable:
                    cost = min(cost, offer[-1] + dfs(tuple(new_remaining)))
            return cost

        return dfs(tuple(needs))
