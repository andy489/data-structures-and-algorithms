# https://leetcode.com/problems/can-i-win/

class Solution:
    def canIWin(self, maxChoosableInteger: int, desiredTotal: int) -> bool:
        if desiredTotal <= 0:
            return True
        total_sum = maxChoosableInteger * (maxChoosableInteger + 1) // 2
        if total_sum < desiredTotal:
            return False
        memo = {}

        def can_win(used_mask: int, remaining: int) -> bool:
            if used_mask in memo:
                return memo[used_mask]
            for i in range(1, maxChoosableInteger + 1):
                if used_mask & (1 << i):
                    continue
                if i >= remaining or not can_win(used_mask | (1 << i), remaining - i):
                    memo[used_mask] = True
                    return True
            memo[used_mask] = False
            return False

        return can_win(0, desiredTotal)
