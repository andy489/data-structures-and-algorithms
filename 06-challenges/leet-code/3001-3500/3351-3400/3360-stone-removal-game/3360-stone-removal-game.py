# https://leetcode.com/problems/stone-removal-game/

class Solution:
    def canAliceWin(self, n: int) -> bool:
        to_remove = 10
        alice_turn = True
        while n >= to_remove:
            n -= to_remove
            to_remove -= 1
            alice_turn = not alice_turn
        return not alice_turn
