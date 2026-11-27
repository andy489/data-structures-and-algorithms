# https://leetcode.com/problems/string-without-aaa-or-bbb/

class Solution:
    def strWithout3a3b(self, a: int, b: int) -> str:
        res = []
        while a or b:
            if a > b:
                res.append('a')
                a -= 1
                if a > b:
                    res.append('a')
                    a -= 1
            else:
                res.append('b')
                b -= 1
                if b > a:
                    res.append('b')
                    b -= 1
        return ''.join(res)
