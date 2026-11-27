# https://leetcode.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/

# Solution: Parity Split — O(n) time, O(n) space
class Solution:
    def maxDepthAfterSplit(self, seq: str) -> List[int]:
        ans = []
        depth = 0
        for c in seq:
            if c == '(':
                depth += 1
                ans.append(depth % 2)
            else:
                ans.append(depth % 2)
                depth -= 1
        return ans
