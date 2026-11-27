# https://leetcode.com/problems/four-divisors/

class Solution:
    def sumFourDivisors(self, nums: list[int]) -> int:
        def divs(n):
            res = []
            d = 1
            while d*d <= n:
                if n%d == 0:
                    res.append(d)
                    if d != n//d:
                        res.append(n//d)
                if len(res) > 4:
                    return []
                d += 1
            return res
        return sum(sum(divs(n)) for n in nums if len(divs(n))==4)
