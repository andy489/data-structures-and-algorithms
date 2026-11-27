# https://leetcode.com/problems/make-array-elements-equal-to-zero/

# Solution: Prefix Sum Balance Check — O(n) time, O(1) space
class Solution:
    def countValidSelections(self, nums: list[int]) -> int:
        total = sum(nums)
        ans = 0
        left_sum = 0
        for x in nums:
            if x == 0:
                right_sum = total - left_sum
                if left_sum == right_sum:
                    ans += 2
                elif left_sum == 0 or right_sum == 0:
                    ans += 1
            else:
                left_sum += x
        return ans
