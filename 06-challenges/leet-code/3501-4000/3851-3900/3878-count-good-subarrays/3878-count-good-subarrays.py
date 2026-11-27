# https://leetcode.com/problems/count-good-subarrays/

class Solution:
    def countGoodSubarrays(self, nums: list[int]) -> int:
        from collections import defaultdict
        n = len(nums)
        ans = 0
        freq = defaultdict(int)
        window_or = 0
        left = 0
        for right in range(n):
            freq[nums[right]] += 1
            window_or |= nums[right]
            cur_max = max(freq)
            while window_or != cur_max:
                freq[nums[left]] -= 1
                if freq[nums[left]] == 0:
                    del freq[nums[left]]
                left += 1
                window_or = 0
                for i in range(left, right + 1):
                    window_or |= nums[i]
                if freq:
                    cur_max = max(freq)
            ans += right - left + 1
        return ans
