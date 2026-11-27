# https://leetcode.com/problems/number-of-equivalent-domino-pairs/

class Solution:
    def numEquivDominoPairs(self, dominoes: list[list[int]]) -> int:
        count = [0] * 100
        ans = 0
        for a, b in dominoes:
            key = min(a, b) * 10 + max(a, b)
            ans += count[key]
            count[key] += 1
        return ans
