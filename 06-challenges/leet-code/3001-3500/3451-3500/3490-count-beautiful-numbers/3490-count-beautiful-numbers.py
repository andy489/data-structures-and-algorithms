# https://leetcode.com/problems/count-beautiful-numbers/

from functools import lru_cache

class Solution:
    def beautifulNumbers(self, l: int, r: int) -> int:
        MOD = 2520  # LCM(1..9), sufficient for digit products

        def count(n: int) -> int:
            if n <= 0:
                return 0
            digits = [int(c) for c in str(n)]
            length = len(digits)

            @lru_cache(maxsize=None)
            def dp(pos, digit_sum, prod_mod, tight):
                if pos == length:
                    if digit_sum == 0:
                        return 0
                    return 1 if prod_mod % digit_sum == 0 else 0
                limit = digits[pos] if tight else 9
                result = 0
                for d in range(limit + 1):
                    if digit_sum == 0 and d == 0:
                        result += dp(pos + 1, 0, 0, tight and d == limit)
                    else:
                        new_sum = digit_sum + d
                        if digit_sum == 0:
                            new_prod = d
                        else:
                            new_prod = (prod_mod * d) % MOD
                        result += dp(pos + 1, new_sum, new_prod, tight and d == limit)
                return result

            result = dp(0, 0, 0, True)
            dp.cache_clear()
            return result

        return count(r) - count(l - 1)
