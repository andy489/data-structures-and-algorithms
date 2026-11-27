# https://leetcode.com/problems/arithmetic-subarrays/

class Solution:
    def checkArithmeticSubarrays(self, nums: list[int], l: list[int], r: list[int]) -> list[bool]:
        def is_arithmetic(sub: list[int]) -> bool:
            sub = sorted(sub)
            diff = sub[1] - sub[0]
            return all(sub[i] - sub[i - 1] == diff for i in range(2, len(sub)))

        return [is_arithmetic(nums[l[i]:r[i] + 1]) for i in range(len(l))]
