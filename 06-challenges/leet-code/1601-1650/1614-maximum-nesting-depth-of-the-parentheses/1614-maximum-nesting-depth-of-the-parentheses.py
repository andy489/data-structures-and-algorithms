# https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/

class Solution:
    def maxDepth(self, s: str) -> int:
        depth = max_d = 0
        for c in s:
            if c == '(':
                depth += 1
                max_d = max(max_d, depth)
            elif c == ')':
                depth -= 1
        return max_d
