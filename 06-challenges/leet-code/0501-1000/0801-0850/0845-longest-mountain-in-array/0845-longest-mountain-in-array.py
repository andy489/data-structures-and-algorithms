# https://leetcode.com/problems/longest-mountain-in-array/

class Solution:
    def longestMountain(self, arr: list[int]) -> int:
        n = len(arr)
        up = [0] * n
        down = [0] * n
        for i in range(1, n):
            if arr[i] > arr[i - 1]:
                up[i] = up[i - 1] + 1
        for i in range(n - 2, -1, -1):
            if arr[i] > arr[i + 1]:
                down[i] = down[i + 1] + 1
        return max((up[i] + down[i] + 1 for i in range(n) if up[i] and down[i]), default=0)
