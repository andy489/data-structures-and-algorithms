# https://leetcode.com/problems/find-missing-observations/

class Solution:
    def missingRolls(self, rolls: list[int], mean: int, n: int) -> list[int]:
        m = len(rolls)
        needed = (m + n) * mean - sum(rolls)
        if needed < n or needed > 6 * n:
            return []
        base, rem = divmod(needed, n)
        return [base + 1] * rem + [base] * (n - rem)
