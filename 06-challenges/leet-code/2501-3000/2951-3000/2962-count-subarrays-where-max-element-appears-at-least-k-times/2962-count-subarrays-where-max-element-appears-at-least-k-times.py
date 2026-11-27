# https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times/
class Solution:
    def countSubarrays(self, nums: list[int], k: int) -> int:
        max_val = max(nums)
        ans = 0
        cnt = 0
        left = 0
        for right in range(len(nums)):
            if nums[right] == max_val:
                cnt += 1
            while cnt >= k:
                if nums[left] == max_val:
                    cnt -= 1
                left += 1
            ans += left
        return ans
