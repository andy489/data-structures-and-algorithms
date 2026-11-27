# https://leetcode.com/problems/count-fancy-numbers-in-a-range/

from functools import lru_cache

class Solution:
    def countFancyNumbers(self, l: int, r: int) -> int:
        def is_good(n: int) -> bool:
            if n < 10:
                return True
            s = str(n)
            inc = all(s[i] < s[i-1] for i in range(1, len(s)))
            dec = all(s[i] > s[i-1] for i in range(1, len(s)))
            return inc or dec

        def count(n: int) -> int:
            if n <= 0:
                return 0
            s = str(n)
            digits = [int(c) for c in s]
            length = len(digits)

            @lru_cache(maxsize=None)
            def dp(pos, tight, dsum, prev, inc, dec, started):
                if pos == length:
                    if not started:
                        return 0
                    good_self = inc or dec
                    good_sum = is_good(dsum)
                    return 1 if (good_self or good_sum) else 0
                limit = digits[pos] if tight else 9
                res = 0
                for d in range(0, limit + 1):
                    new_tight = tight and (d == limit)
                    if not started and d == 0:
                        res += dp(pos + 1, new_tight, 0, -1, True, True, False)
                    else:
                        new_inc = (inc and d > prev) if started else True
                        new_dec = (dec and d < prev) if started else True
                        res += dp(pos + 1, new_tight, dsum + d, d, new_inc, new_dec, True)
                return res

            result = dp(0, True, 0, -1, True, True, False)
            dp.cache_clear()
            return result

        return count(r) - count(l - 1)
