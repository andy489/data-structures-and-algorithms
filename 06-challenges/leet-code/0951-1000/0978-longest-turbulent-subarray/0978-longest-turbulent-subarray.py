# https://leetcode.com/problems/longest-turbulent-subarray/

class Solution:
    def maxTurbulenceSize(self, arr: list[int]) -> int:
        n = len(arr)
        ans = cur = 1
        for i in range(1, n):
            cmp = (arr[i] > arr[i-1]) - (arr[i] < arr[i-1])
            if cmp == 0:
                cur = 1
            elif i > 1 and ((arr[i-1] > arr[i-2]) - (arr[i-1] < arr[i-2])) * cmp > 0:
                cur = 2
            else:
                cur += 1
            ans = max(ans, cur)
        return ans
