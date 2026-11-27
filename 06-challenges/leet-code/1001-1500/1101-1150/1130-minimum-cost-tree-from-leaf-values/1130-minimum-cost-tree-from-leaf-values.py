# https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/

class Solution:
    def mctFromLeafValues(self, arr: list[int]) -> int:
        stack = [float('inf')]
        ans = 0
        for v in arr:
            while stack[-1] <= v:
                mid = stack.pop()
                ans += mid * min(stack[-1], v)
            stack.append(v)
        while len(stack) > 2:
            top = stack.pop()
            ans += top * stack[-1]
        return ans
