# https://leetcode.com/problems/number-of-ways-to-divide-a-long-corridor/
class Solution:
    def numberOfWays(self, corridor: str) -> int:
        MOD = 10 ** 9 + 7
        seat_indices = [i for i, c in enumerate(corridor) if c == 'S']
        total = len(seat_indices)
        if total == 0 or total % 2 != 0:
            return 0
        result = 1
        for i in range(1, total // 2):
            gap = seat_indices[2 * i] - seat_indices[2 * i - 1]
            result = (result * gap) % MOD
        return result
