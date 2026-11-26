# https://leetcode.com/problems/valid-mountain-array/

class Solution:
    def validMountainArray(self, arr: list) -> bool:
        n = len(arr)
        l, r = 0, n - 1
        while l < n - 1 and arr[l] < arr[l + 1]:
            l += 1
        while r > 0 and arr[r] < arr[r - 1]:
            r -= 1
        return l == r and l != 0 and r != n - 1
