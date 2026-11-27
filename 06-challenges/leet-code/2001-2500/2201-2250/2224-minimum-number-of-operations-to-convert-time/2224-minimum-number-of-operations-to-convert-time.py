# https://leetcode.com/problems/minimum-number-of-operations-to-convert-time/
class Solution:
    def convertTime(self, current: str, correct: str) -> int:
        def to_minutes(t: str) -> int:
            return int(t[:2]) * 60 + int(t[3:])

        diff = to_minutes(correct) - to_minutes(current)
        ops = 0
        for inc in [60, 15, 5, 1]:
            ops += diff // inc
            diff %= inc
        return ops
