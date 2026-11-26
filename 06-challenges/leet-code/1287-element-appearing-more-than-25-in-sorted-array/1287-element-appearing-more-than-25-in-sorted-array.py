# https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/

class Solution:
    def findSpecialInteger(self, arr: list[int]) -> int:
        n, q = len(arr), len(arr) // 4
        for i in range(n - q):
            if arr[i] == arr[i + q]:
                return arr[i]
        return -1
