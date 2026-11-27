# https://leetcode.com/problems/duplicate-zeros/

class Solution:
    def duplicateZeros(self, arr: list[int]) -> None:
        zeros = arr.count(0)
        n = len(arr)
        i, j = n - 1, n + zeros - 1
        while i >= 0:
            if arr[i] == 0:
                if j < n: arr[j] = 0
                j -= 1
                if j < n: arr[j] = 0
            else:
                if j < n: arr[j] = arr[i]
            i -= 1; j -= 1
