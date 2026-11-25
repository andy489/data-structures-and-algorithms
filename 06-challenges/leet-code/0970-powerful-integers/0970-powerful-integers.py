# https://leetcode.com/problems/powerful-integers/

class Solution:
    def powerfulIntegers(self, x: int, y: int, bound: int) -> list[int]:
        res = set()
        xi = 1
        while xi <= bound:
            yj = 1
            while xi + yj <= bound:
                res.add(xi + yj)
                if y == 1:
                    break
                yj *= y
            if x == 1:
                break
            xi *= x
        return list(res)
