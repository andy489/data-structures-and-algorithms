# https://leetcode.com/problems/sort-an-array/

class Solution:
    def sortArray(self, nums: list) -> list:
        def merge_sort(arr):
            if len(arr) <= 1:
                return arr
            mid = len(arr) // 2
            left = merge_sort(arr[:mid])
            right = merge_sort(arr[mid:])
            return merge(left, right)

        def merge(a, b):
            result, i, j = [], 0, 0
            while i < len(a) and j < len(b):
                if a[i] <= b[j]:
                    result.append(a[i]); i += 1
                else:
                    result.append(b[j]); j += 1
            return result + a[i:] + b[j:]

        return merge_sort(nums)
