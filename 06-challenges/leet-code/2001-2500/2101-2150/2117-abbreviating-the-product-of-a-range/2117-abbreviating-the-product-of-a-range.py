# https://leetcode.com/problems/abbreviating-the-product-of-a-range/
import math

class Solution:
    def abbreviateProduct(self, left: int, right: int) -> str:
        # Count factors of 2 and 5
        c2, c5 = 0, 0
        for i in range(left, right + 1):
            x = i
            while x % 2 == 0:
                c2 += 1
                x //= 2
            while x % 5 == 0:
                c5 += 1
                x //= 5
        C = min(c2, c5)

        # Try exact computation
        product = 1
        for i in range(left, right + 1):
            product *= i
            if product.bit_length() > 200:
                product = None
                break

        if product is not None:
            while product % 10 == 0:
                product //= 10
            s = str(product)
            if len(s) <= 10:
                return s + 'e' + str(C)

        # Large product: track last 5 digits and log-prefix
        MOD = 100000
        suf = 1
        extra2, extra5 = c2 - C, c5 - C
        for i in range(left, right + 1):
            x = i
            while extra2 > 0 and x % 2 == 0:
                x //= 2
                extra2 -= 1
            while extra5 > 0 and x % 5 == 0:
                x //= 5
                extra5 -= 1
            suf = (suf * x) % MOD

        log_sum = sum(math.log10(i) for i in range(left, right + 1)) - C
        frac = log_sum - int(log_sum)
        pre = int(10 ** (frac + 4))

        return f"{pre}...{suf:05d}e{C}"
