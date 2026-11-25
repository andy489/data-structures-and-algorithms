# https://leetcode.com/problems/ambiguous-coordinates/

class Solution:
    def ambiguousCoordinates(self, s: str) -> list[str]:
        digits = s[1:-1]

        def generate(t):
            res = []
            if not t.startswith('0') or t == '0':
                res.append(t)
            for i in range(1, len(t)):
                dec = t[:i] + '.' + t[i:]
                if (not dec.startswith('0') or dec.startswith('0.')) and not dec.endswith('0'):
                    res.append(dec)
            return res

        return [f"({l}, {r})" for i in range(1, len(digits))
                for l in generate(digits[:i]) for r in generate(digits[i:])]
