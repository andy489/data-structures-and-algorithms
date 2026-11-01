# https://leetcode.com/problems/valid-parentheses/

# Solution: Stack — O(n) time, O(n) space
class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        matching = {')': '(', '}': '{', ']': '['}

        for c in s:
            if c in '({[':
                stack.append(c)
            else:
                if not stack or stack[-1] != matching[c]:
                    return False
                stack.pop()

        return not stack
