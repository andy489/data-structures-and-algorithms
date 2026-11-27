# https://leetcode.com/problems/kth-smallest-instructions/

from math import comb

class Solution:
    def kthSmallestPath(self, destination: list[int], k: int) -> str:
        v, h = destination
        res = []
        while h > 0 and v > 0:
            cnt = comb(h + v - 1, h - 1)
            if k <= cnt:
                res.append('H')
                h -= 1
            else:
                k -= cnt
                res.append('V')
                v -= 1
        res.extend(['H'] * h)
        res.extend(['V'] * v)
        return ''.join(res)
