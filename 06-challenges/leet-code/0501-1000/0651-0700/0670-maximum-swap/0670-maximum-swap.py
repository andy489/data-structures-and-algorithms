# https://leetcode.com/problems/maximum-swap/

class Solution:
    def maximumSwap(self, num: int) -> int:
        digits = list(str(num))
        last = {int(d): i for i, d in enumerate(digits)}
        for i, d in enumerate(digits):
            for bigger in range(9, int(d), -1):
                if last.get(bigger, -1) > i:
                    j = last[bigger]
                    digits[i], digits[j] = digits[j], digits[i]
                    return int(''.join(digits))
        return num
