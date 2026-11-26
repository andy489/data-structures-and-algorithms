# https://leetcode.com/problems/minimum-levels-to-gain-more-points/

class Solution:
    def minimumLevels(self, possible: list[int]) -> int:
        score = [1 if x else -1 for x in possible]
        total = sum(score)
        prefix = 0
        for k in range(len(possible) - 1):
            prefix += score[k]
            if 2 * prefix > total:
                return k + 1
        return -1
