# https://leetcode.com/problems/richest-customer-wealth/

class Solution:
    def maximumWealth(self, accounts: list[list[int]]) -> int:
        return max(sum(row) for row in accounts)
