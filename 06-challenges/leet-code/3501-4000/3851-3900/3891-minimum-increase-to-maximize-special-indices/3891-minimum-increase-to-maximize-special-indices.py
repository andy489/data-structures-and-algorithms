# https://leetcode.com/problems/minimum-increase-to-maximize-special-indices/
class Solution:
    def minimumIncreaseToMaximizeSpecialIndices(self, nums: list[int]) -> int:
        n = len(nums)
        arr = nums[:]
        ops = 0
        i = 1
        while i < n - 1:
            needed = max(arr[i - 1], arr[i + 1]) + 1 - arr[i]
            if needed > 0:
                ops += needed
                arr[i] += needed
            # If i is now special, skip i+1
            if arr[i] > arr[i - 1] and arr[i] > arr[i + 1]:
                i += 2
            else:
                i += 1
        return ops
