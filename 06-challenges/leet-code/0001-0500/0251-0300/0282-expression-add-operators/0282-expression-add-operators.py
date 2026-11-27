# https://leetcode.com/problems/expression-add-operators/

class Solution:
    def addOperators(self, num: str, target: int) -> list[str]:
        res = []

        def backtrack(pos, expr, eval_, mult):
            if pos == len(num):
                if eval_ == target:
                    res.append(expr)
                return
            for i in range(pos, len(num)):
                if i != pos and num[pos] == '0':
                    break
                cur = int(num[pos:i + 1])
                s = str(cur)
                if pos == 0:
                    backtrack(i + 1, s, cur, cur)
                else:
                    backtrack(i + 1, expr + '+' + s, eval_ + cur, cur)
                    backtrack(i + 1, expr + '-' + s, eval_ - cur, -cur)
                    backtrack(i + 1, expr + '*' + s, eval_ - mult + mult * cur, mult * cur)

        backtrack(0, '', 0, 0)
        return res
