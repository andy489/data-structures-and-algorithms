# https://leetcode.com/problems/sum-of-subarray-ranges/

# Solution: Brute Force — O(n^2) time, O(1) space
class Solution:
    def subArrayRanges(self, nums: list[int]) -> int:
        total = 0
        n = len(nums)

        for i in range(n):
            cur_min = cur_max = nums[i]
            for j in range(i + 1, n):
                cur_min = min(cur_min, nums[j])
                cur_max = max(cur_max, nums[j])
                total += cur_max - cur_min

        return total

# Solution 2: Monotonic Stack — O(n) time, O(n) space
class Solution2:
    def subArrayRanges(self, nums: list[int]) -> int:
        def subarray_sum(find_max):
            n = len(nums)
            left = [0] * n
            right = [0] * n
            stack = []

            for i in range(n):
                while stack and (nums[stack[-1]] <= nums[i] if find_max else nums[stack[-1]] >= nums[i]):
                    stack.pop()
                left[i] = i + 1 if not stack else i - stack[-1]
                stack.append(i)

            stack.clear()

            for i in range(n - 1, -1, -1):
                while stack and (nums[stack[-1]] < nums[i] if find_max else nums[stack[-1]] > nums[i]):
                    stack.pop()
                right[i] = n - i if not stack else stack[-1] - i
                stack.append(i)

            return sum(nums[i] * left[i] * right[i] for i in range(n))

        return subarray_sum(True) - subarray_sum(False)
