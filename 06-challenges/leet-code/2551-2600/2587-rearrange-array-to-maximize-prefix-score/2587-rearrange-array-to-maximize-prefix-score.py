# https://leetcode.com/problems/rearrange-array-to-maximize-prefix-score/
class Solution:
    def maxScore(self, nums: list[int]) -> int:
        nums.sort(reverse=True)
        score = 0
        total = 0
        for n in nums:
            total += n
            if total > 0:
                score += 1
            else:
                break
        return score
