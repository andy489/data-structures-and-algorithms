# https://leetcode.com/problems/probability-of-a-two-boxes-having-the-same-number-of-distinct-balls/

class Solution:
    def getProbability(self, balls: list[int]) -> float:
        from math import comb
        from functools import reduce
        k = len(balls)
        half = sum(balls) // 2
        favorable = total = 0.0
        def dfs(idx, b1, b2, d1, d2, ways):
            nonlocal favorable, total
            if b1 > half or b2 > half:
                return
            if idx == k:
                if b1 == half:
                    total += ways
                    if d1 == d2:
                        favorable += ways
                return
            for i in range(balls[idx]+1):
                dfs(idx+1, b1+i, b2+balls[idx]-i,
                    d1+(1 if i>0 else 0), d2+(1 if balls[idx]-i>0 else 0),
                    ways*comb(balls[idx],i))
        dfs(0, 0, 0, 0, 0, 1.0)
        return favorable / total
