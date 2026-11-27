# https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/

# Solution: Stack — O(n²) time, O(n) space
class Solution:
    def reverseParentheses(self, s: str) -> str:
        stack = [[]]
        for c in s:
            if c == '(':
                stack.append([])
            elif c == ')':
                top = stack.pop()
                stack[-1].extend(reversed(top))
            else:
                stack[-1].append(c)
        return ''.join(stack[0])


# Solution 2: Wormhole (Portal) Trick — O(n) time, O(n) space
class Solution2:
    def reverseParentheses(self, s: str) -> str:
        n = len(s)
        pair = [0] * n
        stk = []
        for i, c in enumerate(s):
            if c == '(':
                stk.append(i)
            elif c == ')':
                j = stk.pop()
                pair[i] = j
                pair[j] = i
        res = []
        direction = 1
        i = 0
        while 0 <= i < n:
            c = s[i]
            if c in '()':
                i = pair[i]
                direction = -direction
            else:
                res.append(c)
            i += direction
        return ''.join(res)
