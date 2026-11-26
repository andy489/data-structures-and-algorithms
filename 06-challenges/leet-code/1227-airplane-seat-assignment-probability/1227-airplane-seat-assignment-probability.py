# https://leetcode.com/problems/airplane-seat-assignment-probability/

class Solution:
    def nthPersonGetsNthSeat(self, n: int) -> float:
        return 1.0 if n == 1 else 0.5
