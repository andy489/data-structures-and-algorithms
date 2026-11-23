# https://leetcode.com/problems/super-pow/

class Solution:
    MOD = 1337

    def superPow(self, a: int, b: list[int]) -> int:
        result = 1
        a %= self.MOD
        for d in b:
            result = pow(result, 10, self.MOD) * pow(a, d, self.MOD) % self.MOD
        return result
