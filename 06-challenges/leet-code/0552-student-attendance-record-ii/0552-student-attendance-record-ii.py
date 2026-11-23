# https://leetcode.com/problems/student-attendance-record-ii/
# Solution: DP with 6 states — O(n) time, O(1) space
class Solution:
    def checkRecord(self, n: int) -> int:
        MOD = 10 ** 9 + 7
        a0l0, a0l1, a0l2 = 1, 0, 0
        a1l0, a1l1, a1l2 = 0, 0, 0
        for _ in range(n):
            na0l0 = (a0l0 + a0l1 + a0l2) % MOD
            na0l1 = a0l0
            na0l2 = a0l1
            na1l0 = (a0l0 + a0l1 + a0l2 + a1l0 + a1l1 + a1l2) % MOD
            na1l1 = a1l0
            na1l2 = a1l1
            a0l0, a0l1, a0l2 = na0l0, na0l1, na0l2
            a1l0, a1l1, a1l2 = na1l0, na1l1, na1l2
        return (a0l0 + a0l1 + a0l2 + a1l0 + a1l1 + a1l2) % MOD
