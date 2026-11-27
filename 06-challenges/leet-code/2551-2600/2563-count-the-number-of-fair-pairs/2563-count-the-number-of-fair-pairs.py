# https://leetcode.com/problems/count-the-number-of-fair-pairs/

# Solution: Sort + Two Pointers — O(n log n) time, O(1) space
class Solution:
    def countFairPairs(self, nums: list[int], lower: int, upper: int) -> int:
        nums.sort()

        def count_less(target: int) -> int:
            count = 0
            l, r = 0, len(nums) - 1
            while l < r:
                if nums[l] + nums[r] < target:
                    count += r - l
                    l += 1
                else:
                    r -= 1
            return count

        return count_less(upper + 1) - count_less(lower)
