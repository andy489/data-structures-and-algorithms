# https://leetcode.com/problems/minimum-number-of-coins-to-be-added/
class Solution:
    def minimumAddedCoins(self, coins: list[int], target: int) -> int:
        coins.sort()
        added = 0
        reach = 0
        i = 0
        while reach < target:
            if i < len(coins) and coins[i] <= reach + 1:
                reach += coins[i]
                i += 1
            else:
                reach += reach + 1
                added += 1
        return added
