# https://leetcode.com/problems/number-of-unique-good-subsequences/

class Solution:
    def numberOfUniqueGoodSubsequences(self, binary: str) -> int:
        MOD = 10 ** 9 + 7
        ends1 = 0
        ends0 = 0
        has_zero = False
        for c in binary:
            if c == '1':
                ends1 = (ends1 + ends0 + 1) % MOD
            else:
                ends0 = (ends0 + ends1) % MOD
                has_zero = True
        return (ends1 + ends0 + (1 if has_zero else 0)) % MOD
