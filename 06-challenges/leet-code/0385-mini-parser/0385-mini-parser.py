# https://leetcode.com/problems/mini-parser/

class Solution:
    def deserialize(self, s: str) -> 'NestedInteger':
        if not s.startswith('['):
            return NestedInteger(int(s))
        stack = []
        start = 0
        for i, c in enumerate(s):
            if c == '[':
                stack.append(NestedInteger())
                start = i + 1
            elif c in (']', ','):
                if i > start:
                    stack[-1].add(NestedInteger(int(s[start:i])))
                start = i + 1
                if c == ']' and len(stack) > 1:
                    top = stack.pop()
                    stack[-1].add(top)
        return stack[0]
