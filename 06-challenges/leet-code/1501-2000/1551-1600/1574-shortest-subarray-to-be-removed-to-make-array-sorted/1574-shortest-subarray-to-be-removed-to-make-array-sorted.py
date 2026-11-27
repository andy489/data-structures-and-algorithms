# https://leetcode.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted/

class Solution:
    def findLengthOfShortestSubarray(self, arr: list[int]) -> int:
        n = len(arr)
        r = n - 1
        while r > 0 and arr[r] >= arr[r - 1]:
            r -= 1
        result = r
        l = 0
        while l < r:
            while r < n and arr[r] < arr[l]:
                r += 1
            result = min(result, r - l - 1)
            if arr[l + 1] >= arr[l]:
                l += 1
            else:
                break
        return result
