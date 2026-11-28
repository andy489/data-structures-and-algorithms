# https://leetcode.com/problems/eat-pizzas/

class Solution:
    def maxWeight(self, pizzas: list[int]) -> int:
        pizzas.sort()
        n = len(pizzas)
        days = n // 4
        odd = (days + 1) // 2   # number of odd-indexed days (1-indexed)
        even = days // 2         # number of even-indexed days

        total = 0
        # Odd days: take maximum (Z) = pizzas[n-1], pizzas[n-3], ...
        for i in range(odd):
            total += pizzas[n - 1 - 2 * i]
        # Even days: take 2nd maximum (Y) = pizzas[n-2], pizzas[n-4], ...
        for i in range(even):
            total += pizzas[n - 2 - 2 * i]
        return total
