# https://leetcode.com/problems/jump-game-ii/

class Solution:
    def jump(self, nums: list[int]) -> int:
        jumps = cur_end = farthest = 0
        for i in range(len(nums) - 1):
            farthest = max(farthest, i + nums[i])
            if i == cur_end:        # exhausted current jump's range: must jump
                jumps += 1
                cur_end = farthest
                if cur_end >= len(nums) - 1:
                    break
        return jumps
