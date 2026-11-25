# https://leetcode.com/problems/convert-to-base-2/

class Solution:
    def baseNeg2(self, n: int) -> str:
        if n == 0:
            return "0"
        bits = []
        while n != 0:
            rem = n % (-2)
            n //= (-2)
            if rem < 0:
                rem += 2
                n += 1
            bits.append(str(rem))
        return ''.join(reversed(bits))
