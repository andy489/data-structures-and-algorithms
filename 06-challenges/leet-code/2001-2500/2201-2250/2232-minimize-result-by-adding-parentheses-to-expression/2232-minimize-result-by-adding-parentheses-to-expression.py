# https://leetcode.com/problems/minimize-result-by-adding-parentheses-to-expression/

class Solution:
    def minimizeResult(self, expression: str) -> str:
        plus = expression.index('+')
        n = len(expression)
        best = float('inf')
        best_i = best_j = 0

        for i in range(plus):
            for j in range(plus + 1, n):
                a = int(expression[:i]) if i > 0 else 1
                b = int(expression[i:plus])
                c = int(expression[plus + 1:j + 1])
                d = int(expression[j + 1:]) if j < n - 1 else 1
                val = a * (b + c) * d
                if val < best:
                    best = val
                    best_i, best_j = i, j

        return expression[:best_i] + '(' + expression[best_i:best_j + 1] + ')' + expression[best_j + 1:]
