# https://leetcode.com/problems/recover-the-original-array/
from collections import Counter

class Solution:
    def recoverArray(self, nums: list[int]) -> list[int]:
        nums.sort()
        m = len(nums)
        n = m // 2

        for j in range(1, m):
            diff = nums[j] - nums[0]
            if diff <= 0 or diff % 2 != 0:
                continue
            two_k = diff
            freq = Counter(nums)
            result = []
            valid = True
            for x in nums:
                if freq[x] == 0:
                    continue
                higher = x + two_k
                if freq[higher] == 0:
                    valid = False
                    break
                result.append(x + two_k // 2)
                freq[x] -= 1
                freq[higher] -= 1
            if valid:
                return result
        return []
