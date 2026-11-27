# https://leetcode.com/problems/apply-operations-to-maximize-frequency-score/
class Solution:
    def maxFrequencyScore(self, nums: list[int], k: int) -> int:
        nums.sort()
        n = len(nums)
        prefix = [0] * (n + 1)
        for i in range(n):
            prefix[i + 1] = prefix[i] + nums[i]

        def cost(left: int, right: int) -> int:
            mid = (left + right) // 2
            left_cost = nums[mid] * (mid - left) - (prefix[mid] - prefix[left])
            right_cost = (prefix[right + 1] - prefix[mid + 1]) - nums[mid] * (right - mid)
            return left_cost + right_cost

        result = 1
        left = 0
        for right in range(n):
            while cost(left, right) > k:
                left += 1
            result = max(result, right - left + 1)
        return result
