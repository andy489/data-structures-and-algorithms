# https://leetcode.com/problems/maximum-score-from-removing-stones/

class Solution:
    def maximumScore(self, a: int, b: int, c: int) -> int:
        total = a + b + c
        mx = max(a, b, c)
        rest = total - mx
        return rest if mx >= rest else total // 2
