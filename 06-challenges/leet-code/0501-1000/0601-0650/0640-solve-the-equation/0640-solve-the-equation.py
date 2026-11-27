# https://leetcode.com/problems/solve-the-equation/

class Solution:
    def solveEquation(self, equation: str) -> str:
        def parse(expr):
            x_coef = const = 0
            sign = 1
            num = ""
            for i, c in enumerate(expr):
                if c in '+-':
                    if num:
                        const += sign * int(num)
                    elif i > 0:
                        pass
                    sign = 1 if c == '+' else -1
                    num = ""
                elif c == 'x':
                    x_coef += sign * (int(num) if num else 1)
                    num = ""
                else:
                    num += c
            if num:
                const += sign * int(num)
            return x_coef, const

        eq_idx = equation.index('=')
        lx, lc = parse(equation[:eq_idx])
        rx, rc = parse(equation[eq_idx + 1:])
        x_coef = lx - rx
        const_val = rc - lc
        if x_coef == 0:
            return "Infinite solutions" if const_val == 0 else "No solution"
        return f"x={const_val // x_coef}"
