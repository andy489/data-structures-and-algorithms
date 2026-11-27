# https://leetcode.com/problems/stone-game-vi/

class Solution:
    def stoneGameVI(self, aliceValues: list[int], bobValues: list[int]) -> int:
        combined = sorted(
            zip([a + b for a, b in zip(aliceValues, bobValues)], aliceValues, bobValues),
            reverse=True
        )
        alice_score = sum(a for _, a, _ in combined[0::2])
        bob_score   = sum(b for _, _, b in combined[1::2])
        if alice_score > bob_score:
            return 1
        elif alice_score < bob_score:
            return -1
        return 0
