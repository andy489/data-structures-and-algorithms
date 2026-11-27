# https://leetcode.com/problems/maximum-score-of-a-good-subarray/

class Solution:
    def maximumScore(self, nums: list[int], k: int) -> int:
        n = len(nums)
        i, j = k, k
        min_val = nums[k]
        ans = nums[k]
        while i > 0 or j < n - 1:
            if i == 0:
                j += 1
            elif j == n - 1:
                i -= 1
            elif nums[i - 1] >= nums[j + 1]:
                i -= 1
            else:
                j += 1
            min_val = min(min_val, nums[i], nums[j])
            ans = max(ans, min_val * (j - i + 1))
        return ans
