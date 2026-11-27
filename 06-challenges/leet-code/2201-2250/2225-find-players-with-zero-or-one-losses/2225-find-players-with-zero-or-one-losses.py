# https://leetcode.com/problems/find-players-with-zero-or-one-losses/
class Solution:
    def findWinners(self, matches: List[List[int]]) -> List[List[int]]:
        losses = {}
        for winner, loser in matches:
            if winner not in losses:
                losses[winner] = 0
            losses[loser] = losses.get(loser, 0) + 1
        no_loss = sorted(p for p, l in losses.items() if l == 0)
        one_loss = sorted(p for p, l in losses.items() if l == 1)
        return [no_loss, one_loss]
