# https://leetcode.com/problems/largest-number-after-digit-swaps-by-parity/

class Solution:
    def largestInteger(self, num: int) -> int:
        digits = list(str(num))
        odds = sorted([d for d in digits if int(d) % 2 == 1], reverse=True)
        evens = sorted([d for d in digits if int(d) % 2 == 0], reverse=True)
        oi = ei = 0
        result = []
        for d in digits:
            if int(d) % 2 == 1:
                result.append(odds[oi])
                oi += 1
            else:
                result.append(evens[ei])
                ei += 1
        return int(''.join(result))
