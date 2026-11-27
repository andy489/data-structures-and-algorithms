# https://leetcode.com/problems/maximum-points-in-an-archery-competition/
class Solution:
    def maximumBobPoints(self, numArrows: int, aliceArrows: List[int]) -> List[int]:
        best_mask = 0
        best_score = 0
        for mask in range(1 << 11):
            score = 0
            arrows = 0
            for k in range(1, 12):
                if mask & (1 << k):
                    score += k
                    arrows += aliceArrows[k] + 1
            if arrows <= numArrows and score > best_score:
                best_score = score
                best_mask = mask
        bob = [0] * 12
        used = 0
        for k in range(1, 12):
            if best_mask & (1 << k):
                bob[k] = aliceArrows[k] + 1
                used += bob[k]
        bob[0] = numArrows - used
        return bob
