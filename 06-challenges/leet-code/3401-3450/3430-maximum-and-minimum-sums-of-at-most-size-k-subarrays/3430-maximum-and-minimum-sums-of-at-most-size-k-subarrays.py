# https://leetcode.com/problems/maximum-and-minimum-sums-of-at-most-size-k-subarrays/

class Solution:
    def minMaxSubarraySum(self, nums: list[int], k: int) -> int:
        n = len(nums)

        def get_boundaries(is_max: bool):
            left = [-1] * n
            right = [n] * n
            stack = []
            for i in range(n):
                # For max: pop while stack top <= nums[i] (strict greater left boundary)
                # For min: pop while stack top >= nums[i]
                while stack and (nums[stack[-1]] <= nums[i] if is_max else nums[stack[-1]] >= nums[i]):
                    stack.pop()
                left[i] = stack[-1] if stack else -1
                stack.append(i)
            stack = []
            for i in range(n - 1, -1, -1):
                # For max: pop while stack top < nums[i]
                # For min: pop while stack top > nums[i]
                while stack and (nums[stack[-1]] < nums[i] if is_max else nums[stack[-1]] > nums[i]):
                    stack.pop()
                right[i] = stack[-1] if stack else n
                stack.append(i)
            return left, right

        def count_subarrays(i: int, left: int, right: int) -> int:
            left_span = min(i - left, k)
            right_span = min(right - i, k)
            count = 0
            for dl in range(left_span):
                count += min(right_span, k - dl)
            return count

        left_max, right_max = get_boundaries(True)
        left_min, right_min = get_boundaries(False)

        ans = 0
        for i in range(n):
            ans += nums[i] * count_subarrays(i, left_max[i], right_max[i])
            ans += nums[i] * count_subarrays(i, left_min[i], right_min[i])
        return ans
