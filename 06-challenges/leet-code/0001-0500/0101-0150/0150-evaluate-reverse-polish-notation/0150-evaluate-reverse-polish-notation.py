# https://leetcode.com/problems/evaluate-reverse-polish-notation/

# Solution: Stack — O(n) time, O(n) space
class Solution:
    def evalRPN(self, tokens: list[str]) -> int:
        stack: list[int] = []
        for t in tokens:
            if t in '+-*/':
                b, a = stack.pop(), stack.pop()
                if t == '+': stack.append(a + b)
                elif t == '-': stack.append(a - b)
                elif t == '*': stack.append(a * b)
                else: stack.append(int(a / b))
            else:
                stack.append(int(t))
        return stack[0]
