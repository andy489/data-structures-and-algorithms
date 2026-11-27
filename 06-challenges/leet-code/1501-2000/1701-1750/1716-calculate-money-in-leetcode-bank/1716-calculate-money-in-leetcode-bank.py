# https://leetcode.com/problems/calculate-money-in-leetcode-bank/

class Solution:
    def totalMoney(self, n: int) -> int:
        weeks, days = divmod(n, 7)
        full_weeks = 7 * weeks * (weeks - 1) // 2 + 28 * weeks
        partial = days * (weeks + 1) + days * (days - 1) // 2
        return full_weeks + partial
