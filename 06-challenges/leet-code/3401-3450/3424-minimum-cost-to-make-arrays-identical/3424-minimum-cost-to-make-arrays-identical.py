# https://leetcode.com/problems/minimum-cost-to-make-arrays-identical/

class Solution:
    def minCost(self, arr: list[int], brr: list[int], k: int) -> int:
        cost_no_sort = sum(abs(a - b) for a, b in zip(arr, brr))
        sorted_arr = sorted(arr)
        sorted_brr = sorted(brr)
        cost_with_sort = k + sum(abs(a - b) for a, b in zip(sorted_arr, sorted_brr))
        return min(cost_no_sort, cost_with_sort)
