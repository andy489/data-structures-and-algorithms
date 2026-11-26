# https://leetcode.com/problems/matchsticks-to-square/

class Solution:
    def makesquare(self, matchsticks: list[int]) -> bool:
        total = sum(matchsticks)
        if total % 4 != 0:
            return False
        target = total // 4
        matchsticks.sort(reverse=True)
        if matchsticks[0] > target:
            return False
        sides = [0] * 4

        def backtrack(idx: int) -> bool:
            if idx == len(matchsticks):
                return sides[0] == sides[1] == sides[2] == target
            stick = matchsticks[idx]
            seen = set()
            for i in range(4):
                if sides[i] in seen:
                    continue
                if sides[i] + stick <= target:
                    seen.add(sides[i])
                    sides[i] += stick
                    if backtrack(idx + 1):
                        return True
                    sides[i] -= stick
            return False

        return backtrack(0)
