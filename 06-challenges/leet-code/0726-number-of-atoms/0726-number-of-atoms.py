# https://leetcode.com/problems/number-of-atoms/

from collections import defaultdict

class Solution:
    def countOfAtoms(self, formula: str) -> str:
        stack = [defaultdict(int)]
        i, n = 0, len(formula)
        while i < n:
            c = formula[i]
            if c == '(':
                stack.append(defaultdict(int))
                i += 1
            elif c == ')':
                i += 1
                start = i
                while i < n and formula[i].isdigit():
                    i += 1
                mult = int(formula[start:i]) if i > start else 1
                top = stack.pop()
                for elem, cnt in top.items():
                    stack[-1][elem] += cnt * mult
            elif c.isupper():
                start = i
                i += 1
                while i < n and formula[i].islower():
                    i += 1
                elem = formula[start:i]
                start = i
                while i < n and formula[i].isdigit():
                    i += 1
                count = int(formula[start:i]) if i > start else 1
                stack[-1][elem] += count
        counts = stack[0]
        return ''.join(elem + (str(counts[elem]) if counts[elem] > 1 else '')
                       for elem in sorted(counts))
