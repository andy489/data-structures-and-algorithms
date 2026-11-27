# https://leetcode.com/problems/second-largest-digit-in-a-string/

class Solution:
    def secondHighest(self, s: str) -> int:
        digits = sorted({int(c) for c in s if c.isdigit()}, reverse=True)
        return digits[1] if len(digits) >= 2 else -1
