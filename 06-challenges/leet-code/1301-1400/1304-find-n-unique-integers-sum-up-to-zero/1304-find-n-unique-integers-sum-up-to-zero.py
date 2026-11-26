# https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/

class Solution:
    def sumZero(self, n: int) -> list[int]:
        res = list(range(1, n))
        res.append(-sum(res))
        return res
