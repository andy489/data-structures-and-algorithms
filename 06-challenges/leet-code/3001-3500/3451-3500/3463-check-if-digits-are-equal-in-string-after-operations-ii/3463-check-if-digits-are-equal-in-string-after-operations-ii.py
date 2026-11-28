# https://leetcode.com/problems/check-if-digits-are-equal-in-string-after-operations-ii/

class Solution:
    def hasSameDigits(self, s: str) -> bool:
        n = len(s)
        digits = [int(c) for c in s]
        length = n - 2  # = C(n-2, i) row

        # Compute Pascal row C(length, i) mod 10 incrementally
        binom = [0] * (length + 1)
        binom[0] = 1
        for r in range(1, length + 1):
            for col in range(r, 0, -1):
                binom[col] = (binom[col] + binom[col - 1]) % 10

        d0 = sum(binom[i] * digits[i] for i in range(length + 1)) % 10
        d1 = sum(binom[i] * digits[i + 1] for i in range(length + 1)) % 10
        return d0 == d1
