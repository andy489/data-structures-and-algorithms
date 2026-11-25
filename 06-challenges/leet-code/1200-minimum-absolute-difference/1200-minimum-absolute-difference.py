# https://leetcode.com/problems/minimum-absolute-difference/

class Solution:
    def minimumAbsDifference(self, arr: list[int]) -> list[list[int]]:
        arr.sort()
        min_diff = min(arr[i+1]-arr[i] for i in range(len(arr)-1))
        return [[arr[i], arr[i+1]] for i in range(len(arr)-1) if arr[i+1]-arr[i] == min_diff]
