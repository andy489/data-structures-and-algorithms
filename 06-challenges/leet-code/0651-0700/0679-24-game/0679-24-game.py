# https://leetcode.com/problems/24-game/

class Solution:
    def judgePoint24(self, cards: list) -> bool:
        def solve(nums):
            if len(nums) == 1:
                return abs(nums[0] - 24) < 1e-6
            for i in range(len(nums)):
                for j in range(len(nums)):
                    if i == j:
                        continue
                    rest = [nums[k] for k in range(len(nums)) if k != i and k != j]
                    a, b = nums[i], nums[j]
                    for c in (a + b, a - b, a * b, a / b if b else None):
                        if c is not None and solve(rest + [c]):
                            return True
            return False
        return solve([float(c) for c in cards])
