# https://leetcode.com/problems/minimum-cost-to-make-array-equalindromic/
class Solution:
    def minimumCost(self, nums: list[int]) -> int:
        def is_palindrome(n: int) -> bool:
            s = str(n)
            return s == s[::-1]

        def cost(target: int) -> int:
            return sum(abs(x - target) for x in nums)

        nums.sort()
        median = nums[len(nums) // 2]
        left = right = median
        while not is_palindrome(left):
            left -= 1
        while not is_palindrome(right):
            right += 1
        return min(cost(left), cost(right))
