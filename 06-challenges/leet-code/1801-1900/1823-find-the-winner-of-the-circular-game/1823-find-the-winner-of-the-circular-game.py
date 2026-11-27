# https://leetcode.com/problems/find-the-winner-of-the-circular-game/

class Solution:
    def findTheWinner(self, n: int, k: int) -> int:
        pos = 0
        for i in range(2, n + 1):
            pos = (pos + k) % i
        return pos + 1
