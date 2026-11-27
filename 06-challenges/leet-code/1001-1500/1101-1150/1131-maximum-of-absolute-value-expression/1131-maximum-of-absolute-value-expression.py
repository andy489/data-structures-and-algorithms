# https://leetcode.com/problems/maximum-of-absolute-value-expression/

class Solution:
    def maxAbsValExpr(self, arr1: list[int], arr2: list[int]) -> int:
        ans = 0
        for s1 in (1, -1):
            for s2 in (1, -1):
                f_vals = [s1 * a + s2 * b + i for i, (a, b) in enumerate(zip(arr1, arr2))]
                g_vals = [s1 * a + s2 * b - i for i, (a, b) in enumerate(zip(arr1, arr2))]
                ans = max(ans, max(f_vals) - min(f_vals), max(g_vals) - min(g_vals))
        return ans
