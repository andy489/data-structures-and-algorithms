# https://leetcode.com/problems/rotated-digits/

class Solution:
    def rotatedDigits(self, n: int) -> int:
        invalid = {3, 4, 7}
        changing = {2, 5, 6, 9}
        count = 0
        for i in range(1, n + 1):
            digits = [int(d) for d in str(i)]
            if not any(d in invalid for d in digits) and any(d in changing for d in digits):
                count += 1
        return count
