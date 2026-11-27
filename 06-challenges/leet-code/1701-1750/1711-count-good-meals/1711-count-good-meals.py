# https://leetcode.com/problems/count-good-meals/

from collections import defaultdict

class Solution:
    def countPairs(self, deliciousness: list[int]) -> int:
        MOD = 10 ** 9 + 7
        freq = defaultdict(int)
        count = 0
        for d in deliciousness:
            for i in range(22):
                p = 1 << i
                count = (count + freq[p - d]) % MOD
            freq[d] += 1
        return count
