# https://leetcode.com/problems/parsing-a-boolean-expression/

# Solution: Stack-Based Parsing — O(n) time, O(n) space
class Solution:
    def parseBoolExpr(self, expression: str) -> bool:
        stack = []
        for c in expression:
            if c == ',':
                continue
            if c != ')':
                stack.append(c)
            else:
                vals = []
                while stack[-1] != '(':
                    vals.append(stack.pop())
                stack.pop()  # remove '('
                op = stack.pop()
                if op == '!':
                    result = 'f' if vals[0] == 't' else 't'
                elif op == '&':
                    result = 'f' if 'f' in vals else 't'
                else:  # '|'
                    result = 't' if 't' in vals else 'f'
                stack.append(result)
        return stack[-1] == 't'
