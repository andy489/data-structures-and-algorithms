# https://leetcode.com/problems/first-day-where-you-have-been-in-all-the-rooms/
class Solution:
    def firstDayBeenInAllRooms(self, nextVisit: list[int]) -> int:
        MOD = 10 ** 9 + 7
        n = len(nextVisit)
        dp = [0] * n
        for i in range(1, n):
            dp[i] = (2 * dp[i - 1] - dp[nextVisit[i - 1]] + 2) % MOD
        return dp[n - 1]
