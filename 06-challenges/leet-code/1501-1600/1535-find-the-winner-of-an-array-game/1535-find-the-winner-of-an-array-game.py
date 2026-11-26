# https://leetcode.com/problems/find-the-winner-of-an-array-game/

class Solution:
    def getWinner(self, arr: list[int], k: int) -> int:
        current = arr[0]
        wins = 0
        for i in range(1, len(arr)):
            if arr[i] > current:
                current = arr[i]
                wins = 1
            else:
                wins += 1
            if wins >= k:
                return current
        return current
