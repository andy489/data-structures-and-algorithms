# https://leetcode.com/problems/check-if-word-is-valid-after-substitutions/

class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        for c in s:
            if c == 'c':
                if len(stack) < 2 or stack[-1] != 'b' or stack[-2] != 'a':
                    return False
                stack.pop()
                stack.pop()
            else:
                stack.append(c)
        return not stack
