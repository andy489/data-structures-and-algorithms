# https://leetcode.com/problems/complex-number-multiplication/

class Solution:
    def complexNumberMultiply(self, num1: str, num2: str) -> str:
        def parse(s: str) -> tuple[int, int]:
            plus_idx = s.rfind('+')
            return int(s[:plus_idx]), int(s[plus_idx+1:-1])

        a, b = parse(num1)
        c, d = parse(num2)
        return f"{a*c - b*d}+{a*d + b*c}i"
